package fr.miage.toulouse.membersAdmin.web.controller;

import fr.miage.toulouse.membersAdmin.services.AdminService;
import fr.miage.toulouse.membersAdmin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.miage.toulouse.membersAdmin.model.*;

@RestController
public class membersController {
    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/api/vamarcher/1.0/membres", method = RequestMethod.GET)
    public Iterable<Membre> listeMembres(){
        return adminService.listerMembres();
    }

    @RequestMapping(value = "/api/vamarcher/1.0/membre/{id}", method = RequestMethod.GET)
    public Membre getMembre(@PathVariable int id){
        return userService.getOneMembre(id);
    }

    @PostMapping(value = "/api/vamarcher/1.0/membre/add")
    public Membre ajouterMembre(@RequestParam String nomMembre, @RequestParam String prenomMembre,
                             @RequestParam String mail, @RequestParam String login, @RequestParam String password,
                                @RequestParam int numero, @RequestParam String rue, @RequestParam String ville,
                                @RequestParam String pays){
        Membre membre = new Membre();
        Adresse adresse = new Adresse();
        membre.setNomMembre(nomMembre);
        membre.setPrenomMembre(prenomMembre);
        membre.setMailMembre(mail);
        membre.setLogin(login);
        membre.hashPassword(password);

        adresse.setNumero(numero);
        adresse.setRue(rue);
        adresse.setVille(ville);
        adresse.setPays(pays);

        membre.setAdresse(adresse);
        return userService.inscription(membre);
    }

    @PostMapping(value = "/api/vamarcher/1.0/membre/promote")
    public String promote(@RequestParam Integer userID){
       return adminService.promoteTeamLeader(userID);
    }

    @PostMapping(value = "/api/vamarcher/1.0/stats/nombre")
    public Integer membres(){
        return adminService.stats();
    }

    @PostMapping(path = "/api/vamarcher/1.0/membre/login")
    public Membre login(@RequestParam String login, @RequestParam String password){
        return userService.login(login, password);
    }
}
