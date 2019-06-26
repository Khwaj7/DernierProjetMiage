package fr.miage.toulouse.vamarcher.randoadmin.controller;

import fr.miage.toulouse.vamarcher.randoadmin.model.Rando;
import fr.miage.toulouse.vamarcher.randoadmin.model.Vote;
import fr.miage.toulouse.vamarcher.randoadmin.repo.RandoRepository;
import fr.miage.toulouse.vamarcher.randoadmin.service.MembreService;
import fr.miage.toulouse.vamarcher.randoadmin.service.TeamLeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class RandoController {

    @Autowired
    private TeamLeaderService teamLeaderService;

    @Autowired
    private MembreService membreService;

    /**
     * Retourne toute les randos
     * @return
     */
    @RequestMapping(path = "/api/vamarcher/1.0/randos", method = RequestMethod.GET)
    public Iterable<Rando> getRandos(){
        return membreService.listerRandos();
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
        return teamLeaderService.proposerRando(rando);
    }

    /**
     * Effectue les actions lors de la cloture d'un vote
     * @param randoId
     * @return
     */
    @PostMapping(path = "/api/vamarcher/1.0/rando/clotureVote")
    public Rando clotureVote (@RequestParam String randoId){
        return teamLeaderService.cloturerVote(randoId);
    }

    /**
     * Effectue les actions lors de la cloture d'une organisation
     * @param randoId
     * @return
     */
    @PostMapping(path = "/api/vamarcher/1.0/rando/cloturerOrga")
    public Rando clotuterOrga(@RequestParam String randoId){
        return teamLeaderService.cloturerOrga(randoId);
    }
    
    /**
     * Supprime une randonnée
     * @param randoId String Id de la Rando
     * @return status
     */
    @DeleteMapping(path = "/api/vamarcher/1.0/rando/annulerRando")
    private String annulerRando(@RequestParam String randoId){
        return teamLeaderService.annulerRando(randoId);
    }

    /**
     * Ajoute un vote pour la date d'une randonnée
     * @param idRando
     * @param date
     * @param userID
     * @return
     */
    @PostMapping(path="/api/vamarcher/1.0/rando/vote")
    public String voterPour(@RequestParam String idRando, @RequestParam String date, @RequestParam Integer userID){
        return membreService.voter(idRando, date, userID);
    }

    /**
     * Inscrption d'un randonneur à une randonnée.
     * @param idRando
     * @param userID
     * @return String : status
     */
    @PostMapping(path = "/api/vamarcher/1.0/rando/inscription")
    public String inscription (@RequestParam String idRando, @RequestParam Integer userID){
        return membreService.inscrire(idRando, userID);
    }

    /**
     *
     * @param idRando
     * @param userID
     * @return String : status
     */
    @DeleteMapping(path = "/api/vamarcher/1.0/rando/desinscription")
    public String desinscription(@RequestParam String idRando, @RequestParam Integer userID){
        return membreService.desinscrire(idRando, userID);
    }
}
