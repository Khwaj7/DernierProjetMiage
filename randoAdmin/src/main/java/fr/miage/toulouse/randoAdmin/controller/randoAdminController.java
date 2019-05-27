package fr.miage.toulouse.randoAdmin.controller;

import fr.miage.toulouse.randoAdmin.model.Membre;
import fr.miage.toulouse.randoAdmin.repo.RandoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class randoAdminController {
    @Autowired
    private RandoRepository randoRepository;

    @RequestMapping( value = "/admin/teamleader/{id}", method = RequestMethod.GET)
    public boolean isTeamLeader(@PathVariable int id){

        return true;
    }

    @PostMapping(path="/admin/teamleader/add")
    public Membre promoteTeamLeader(@RequestParam int id){

        //vérifier que le membre existe

        //lui attribuer les droits
        return null;
    }


}
