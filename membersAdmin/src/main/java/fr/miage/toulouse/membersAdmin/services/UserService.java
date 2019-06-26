package fr.miage.toulouse.membersAdmin.services;

import fr.miage.toulouse.membersAdmin.model.Membre;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * Ajoute un nouveau membre dans la base de données
     * @param membre
     * @return Membre | null
     */
    Membre inscription(Membre membre);

    /**
     * Récupère un membre dans la base de données à partir de son ID
     * @param id
     * @return Membre | null
     */
    Membre getOneMembre(Integer id);

    /**
     * Authentification d'un membre avec son login / MDP
     * @param login
     * @param password
     * @return Membre | null
     */
    Membre login(String login, String password);

}
