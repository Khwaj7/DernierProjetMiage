package fr.miage.toulouse.membersAdmin.web.controller;

import fr.miage.toulouse.membersAdmin.dao.MembreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.miage.toulouse.membersAdmin.model.*;

import java.util.Optional;

@RestController
public class membersController {
    @Autowired
    private MembreDao membreDao;

    @RequestMapping(value="/membres", method = RequestMethod.GET)
    public Iterable<Membre> listeMembres(){
        return membreDao.findAll();
    }

    @RequestMapping(value = "/membre/{id}", method = RequestMethod.GET)
    public Optional<Membre> getMembre(@PathVariable int id){
        return membreDao.findById(id);
    }

    @PostMapping(value = "/membre")
    public int ajouterMembre(@RequestBody Membre membre){
        membreDao.save(membre);
        return membre.getId();
    }
}
