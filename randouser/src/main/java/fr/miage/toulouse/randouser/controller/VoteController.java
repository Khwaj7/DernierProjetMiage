package fr.miage.toulouse.randouser.controller;

import fr.miage.toulouse.randouser.model.Rando;
import fr.miage.toulouse.randouser.model.Vote;
import fr.miage.toulouse.randouser.repo.RandoRepository;
import fr.miage.toulouse.randouser.repo.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class VoteController {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private RandoRepository randoRepository;

    @PostMapping(path = "/vote/apply")
    public Rando voterPour(@RequestParam String randoId, @RequestParam String date, @RequestParam Integer idRandonneur){
        Vote vote = new Vote();
        Rando rando = randoRepository.findbyRandoId(randoId);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            vote.setDate(formatter.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        vote.setUserId(idRandonneur);
        vote.setRando(rando);
        HashMap<Date, List<Vote>> lesVotes = rando.getPropositionsDates();
        lesVotes.get(vote.getDate()).add(vote);
        rando.setPropositionsDates(lesVotes);
        return randoRepository.save(rando);
    }
}
