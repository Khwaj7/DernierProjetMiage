package fr.miage.toulouse.membersAdmin.web.controller;

import fr.miage.toulouse.membersAdmin.dao.MembreDao;
import fr.miage.toulouse.membersAdmin.dao.TeamLeaderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.miage.toulouse.membersAdmin.model.*;

import java.util.Optional;

@RestController
public class membersController {
    @Autowired
    private MembreDao membreDao;

    @Autowired
    private TeamLeaderDao teamLeaderDao;

    @RequestMapping(value="/membres", method = RequestMethod.GET)
    public Iterable<Membre> listeMembres(){
        return membreDao.findAll();
    }

    @RequestMapping(value = "/membre/{id}", method = RequestMethod.GET)
    public Optional<Membre> getMembre(@PathVariable int id){
        return membreDao.findById(id);
    }

    @PostMapping(value = "/membre")
    public void ajouterMembre(@RequestBody Membre membre){
        membreDao.save(membre);
    }

    @PostMapping(value = "/membre/promote")
    public String promote(@RequestParam Integer userID){
        try{
            Optional<Membre> membre = membreDao.findById(userID);
            TeamLeader teamLeader = new TeamLeader(membre.get());
            teamLeaderDao.save(teamLeader);
            return "Promotion validée";
        } catch (Exception e){
            return "KO";
        }
    }
}
