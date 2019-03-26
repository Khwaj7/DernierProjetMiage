package fr.miage.toulouse.membersAdmin.web.controller;

import fr.miage.toulouse.membersAdmin.dao.MembreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.miage.toulouse.membersAdmin.model.*;

import java.util.List;

@RestController
public class membersController {
    @Autowired
    private MembreDao membreDao;

    @RequestMapping(value="/membres", method = RequestMethod.GET)
    public List<Membre> listeMembres(){
        return membreDao.findAll();
    }

    @RequestMapping(value = "/membre/{id}", method = RequestMethod.GET)
    public Membre getMembre(@PathVariable int id){
        return membreDao.findById(id);
    }

    @PostMapping(value = "/membre")
    public void ajouterMembre(@RequestBody Membre membre){
        membreDao.save(membre);
    }
}
