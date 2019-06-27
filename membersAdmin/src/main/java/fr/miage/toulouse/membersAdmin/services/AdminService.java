package fr.miage.toulouse.membersAdmin.services;

import fr.miage.toulouse.membersAdmin.model.Membre;
import fr.miage.toulouse.membersAdmin.model.TeamLeader;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    /**
     * Retourne la liste de tous les membres
     * @return
     */
    Iterable<Membre> listerMembres();

    /**
     * Donne une promotion a un Membre en le nommant TeamLeader
     * @param userID
     * @return
     */
    String promoteTeamLeader(Integer userID);

    /**
     * Truc qui fait des stats
     * @return
     */
    Integer stats();

    /**
     * Retourne la liste des TeamLeader
     * @return
     */
    Iterable<TeamLeader> listeTeamLeaders();

}
