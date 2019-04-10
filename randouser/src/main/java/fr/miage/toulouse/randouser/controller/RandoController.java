package fr.miage.toulouse.randouser.controller;

import fr.miage.toulouse.randouser.model.Rando;
import fr.miage.toulouse.randouser.repo.RandoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class RandoController {

    @Autowired
    private RandoRepository randoRepository;

    @RequestMapping(path = "randos", method = RequestMethod.GET)
    public Iterable<Rando> getRandos(){
        return randoRepository.findAll();
    }

    @PostMapping(path = "/rando/add")
    public Rando addNewRando(@RequestParam(required = false) Timestamp dateRetenue,@RequestParam(required = false) List<Timestamp> propositionsDates,@RequestParam(required = false) String pointDepart,@RequestParam(required = false) String description,
                             @RequestParam(required = false) String distance,@RequestParam(required = false) String duree,@RequestParam(required = false) String denivele,@RequestParam(required = false) String niveau,@RequestParam(required = false) List<Integer> participants){
        Rando rando = new Rando();
        rando.setDateRetenue(dateRetenue);
        rando.setPropositionsDates(propositionsDates);
        rando.setPointDepart(pointDepart);
        rando.setDescription(description);
        rando.setDistance(distance);
        rando.setDuree(duree);
        rando.setDenivele(denivele);
        rando.setNiveau(niveau);
        rando.setParticipants(participants);
        return randoRepository.save(rando);
    }
}
