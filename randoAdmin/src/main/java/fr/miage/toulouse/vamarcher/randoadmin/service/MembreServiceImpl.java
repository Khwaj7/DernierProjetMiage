package fr.miage.toulouse.vamarcher.randoadmin.service;

import fr.miage.toulouse.vamarcher.randoadmin.model.Rando;
import fr.miage.toulouse.vamarcher.randoadmin.model.Vote;
import fr.miage.toulouse.vamarcher.randoadmin.repo.RandoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MembreServiceImpl implements MembreService {

    @Autowired
    RandoRepository randoRepository;

    @Override
    public Iterable<Rando> listerRandos() {
        return randoRepository.findAll();
    }

    @Override
    public String voter(String idRando, String date, Integer userID) {
        try{
            Rando rando = randoRepository.findbyRandoId(idRando);
            if (!rando.getStatut().equals("Vote ouvert")){
                throw  new Exception("Le vote n'est pas disponible pour cette randonnée");
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date tmp = formatter.parse(date);
            Timestamp timestamp = new Timestamp(tmp.getTime());
            Vote vote = new Vote();
            vote.setDate(tmp);
            vote.setUserId(userID);
            List<Vote> votes = rando.getPropositionsDates().get(timestamp.getTime());
            if (votes.contains(vote)){
                throw new Exception("Vous avez déjà voté pour cette date");
            }
            votes.add(vote);
            rando.getPropositionsDates().replace(timestamp.getTime(), votes);
            randoRepository.save(rando);
            return "vote OK";
        } catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String inscrire(String idRando, Integer userId) {
        try{
            Rando rando = randoRepository.findbyRandoId(idRando);
            if (rando.getStatut().equals("Cloturée")){
                throw new Exception("Inscription impossible : l'organisation est cloturée");
            }
            if (rando.getParticipants() == null){
                rando.setParticipants(new ArrayList<Integer>());
            }
            if (rando.getParticipants().contains(userId)){
                throw new Exception("L'utilisateur est déjà inscrit");
            }
            rando.getParticipants().add(userId);
            randoRepository.save(rando);
            return "Inscription validée";
        } catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String desinscrire(String idRando, Integer userID) {
        try{
            Rando rando = randoRepository.findbyRandoId(idRando);
            if (!rando.getParticipants().contains(userID)){
                throw new Exception("L'utilisteur n'est pas inscrit");
            }
            int index = rando.getParticipants().indexOf(userID);
            rando.getParticipants().remove(index);
            return "Désinscription confirmée";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
