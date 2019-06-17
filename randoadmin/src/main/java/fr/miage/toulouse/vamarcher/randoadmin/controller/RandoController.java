package fr.miage.toulouse.vamarcher.randoadmin.controller;

import fr.miage.toulouse.vamarcher.randoadmin.model.Rando;
import fr.miage.toulouse.vamarcher.randoadmin.model.Vote;
import fr.miage.toulouse.vamarcher.randoadmin.repo.RandoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class RandoController {

    @Autowired
    private RandoRepository randoRepository;

    /**
     * Retourne toute les randos
     * @return
     */
    @RequestMapping(path = "/api/vamarcher/1.0/randos", method = RequestMethod.GET)
    public Iterable<Rando> getRandos(){
        return randoRepository.findAll();
    }

    /**
     * Ajoute une nouvelle randonnée sur l'application VaMarcher
     * @param propositionsDates
     * @param pointDepart
     * @param description
     * @param distance
     * @param duree
     * @param denivele
     * @param niveau
     * @param coutFixe
     * @param coutVariable
     * @return
     */
    @PostMapping(path = "/api/vamarcher/1.0/rando/add")
    public Rando addNewRando(@RequestParam List<String> propositionsDates,@RequestParam String pointDepart,
                             @RequestParam String description, @RequestParam String distance,
                             @RequestParam String duree, @RequestParam String denivele,
                             @RequestParam String niveau, @RequestParam float coutFixe,
                             @RequestParam float coutVariable){
        Rando rando = new Rando();
        HashMap<Long, List<Vote>> dates = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (String date: propositionsDates) {
            Date tmp = null;
            Timestamp ts = null;
            try {
                tmp = formatter.parse(date);
                ts = new Timestamp(tmp.getTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
            dates.put(ts.getTime(), new ArrayList<Vote>());
        }
        rando.setPropositionsDates(dates);
        rando.setPointDepart(pointDepart);
        rando.setDescription(description);
        rando.setDistance(distance);
        rando.setDuree(duree);
        rando.setDenivele(denivele);
        rando.setNiveau(niveau);
        rando.setCoutFixe(coutFixe);
        rando.setCoutVariable(coutVariable);
        rando.setStatut("Vote ouvert");
        return randoRepository.save(rando);
    }

    /**
     * Effectue les actions lors de la cloture d'un vote
     * @param randoId
     * @return
     */
    @PostMapping(path = "/api/vamarcher/1.0/rando/clotureVote")
    public Rando clotureVote (@RequestParam String randoId){
        Rando rando = randoRepository.findbyRandoId(randoId);
        HashMap<Long, List<Vote>> votes = rando.getPropositionsDates();
        Timestamp bestDate = getBestDate(votes);
        rando.setDateRetenue(bestDate);
        rando = inscrireParticipants(rando);
        return randoRepository.save(rando);
    }

    /**
     * Effectue les actions lors de la cloture d'une organisation
     * @param randoId
     * @return
     */
    @PostMapping(path = "/api/vamarcher/1.0/rando/cloturerOrga")
    public Rando clotuterOrga(@RequestParam String randoId){
        Rando rando = randoRepository.findbyRandoId(randoId);
        rando.setStatut("Cloturée");
        return randoRepository.save(rando);
    }


    //TODO A dégager juste pour test
    @DeleteMapping(path = "/randos/deleteAll")
    public String deleteAllRandos (){
        randoRepository.deleteAll();
        return "OK";
    }


    /**
     * Retourne la meilleure date selon les votes pour une rando
     * @param lesVotes La HashMap des votes d'une rando
     * @return Timestamp : La meilleure rando
     */
    private Timestamp getBestDate(HashMap<Long, List<Vote>> lesVotes){
        Timestamp bestDate = null;
        int count = 0;
        for (Long key : lesVotes.keySet()){
            if (count < lesVotes.get(key).size()){
                count = lesVotes.get(key).size();
                bestDate = new Timestamp(key);
            }
        }
        return bestDate;
    }

    /**
     * Inscrit d'office les participants qui ont voté pour la date retenue
     * @param rando Rando a modifier
     * @return Rando mise à jour
     */
    private Rando inscrireParticipants(Rando rando){
        List<Integer> participants = rando.getParticipants();
        for (Vote vote : rando.getPropositionsDates().get(rando.getDateRetenue().getTime())){
            if (!participants.contains(vote.getUserId())){
                participants.add(vote.getUserId());
            }
        }
        rando.setParticipants(participants);
        return rando;
    }

    
    /**
     * Supprime une randonnée
     * @param randoId String Id de la Rando
     * @return status
     */
    @DeleteMapping(path = "/api/vamarcher/1.0/rando/annulerRando")
    private String annulerRando(@RequestParam String randoId){
        try{
            Rando rando = randoRepository.findbyRandoId(randoId);
            randoRepository.delete(rando);
            return "Done";
        } catch (Exception e){
            return "NOK";
        }
    }
}
