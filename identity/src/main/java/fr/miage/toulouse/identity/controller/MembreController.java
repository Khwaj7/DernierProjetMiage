package fr.miage.toulouse.identity.controller;

import fr.miage.toulouse.identity.metier.Membre;
import fr.miage.toulouse.identity.repo.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MembreController {

    @Autowired
    private MembreRepository membreRepository;

    @RequestMapping(value = "/Membres", method = RequestMethod.GET)
    public String membres(){
        return "plop";
    }

    @GetMapping(path = "/add")
    public Membre addNewMembre(@RequestParam String nomMembre, @RequestParam String prenomMembre,
                               @RequestParam String mail, @RequestParam String login, @RequestParam String password){
        Membre membre = new Membre();
        membre.setNomMembre(nomMembre);
        membre.setPrenomMembre(prenomMembre);
        membre.setMailMembre(mail);
        membre.setLogin(login);
        membre.setEncryptedPassword(password);
        return membreRepository.save(membre);
    }
}