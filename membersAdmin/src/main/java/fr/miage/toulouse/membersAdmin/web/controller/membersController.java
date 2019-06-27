package fr.miage.toulouse.membersAdmin.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.miage.toulouse.membersAdmin.services.AdminService;
import fr.miage.toulouse.membersAdmin.services.UserService;
import org.json.JSONObject;
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

    @GetMapping(value = "/api/vamarcher/1.0/teamleaders")
    public Iterable<TeamLeader> listeTeamLeader(){
        return adminService.listeTeamLeaders();
    }

    @PostMapping(value = "/api/vamarcher/1.0/membre/add")
    public Membre ajouterMembre(@RequestBody Membre membre){
        Membre lemembre = membre;
        lemembre.hashPassword(membre.getEncryptedPassword());
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
