package fr.miage.toulouse.membersAdmin.services;

import fr.miage.toulouse.membersAdmin.model.Membre;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    Membre inscription(Membre membre);

    Membre getOneMembre(Integer id);

    Membre login(String login, String password);

}
