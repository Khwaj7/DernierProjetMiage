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


}
