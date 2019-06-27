package fr.miage.toulouse.vamarcher.randoadmin.service;

import fr.miage.toulouse.vamarcher.randoadmin.model.Rando;
import fr.miage.toulouse.vamarcher.randoadmin.model.Vote;
import fr.miage.toulouse.vamarcher.randoadmin.repo.RandoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@Service
public class TeamLeaderServiceImpl implements TeamLeaderService {

    @Autowired
    RandoRepository randoRepository;

    @Override
    public Rando proposerRando(Rando rando) {
        return randoRepository.save(rando);
    }

    @Override
    public Rando cloturerVote(String randoId) {
        Rando rando = randoRepository.findbyRandoId(randoId);
        HashMap<Long, List<Vote>> votes = rando.getPropositionsDates();
        Timestamp bestDate = getBestDate(votes);
        rando.setDateRetenue(bestDate);
        rando = inscrireParticipants(rando);
        return randoRepository.save(rando);
    }

    @Override
    public Rando cloturerOrga(String randoId) {
        Rando rando = randoRepository.findbyRandoId(randoId);
        rando.setStatut("Cloturée");
        return randoRepository.save(rando);
    }

    @Override
    public String annulerRando(String randoId) {
        try{
            Rando rando = randoRepository.findbyRandoId(randoId);
            randoRepository.delete(rando);
            return "Done";
        } catch (Exception e){
            return "NOK";
        }
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
}
