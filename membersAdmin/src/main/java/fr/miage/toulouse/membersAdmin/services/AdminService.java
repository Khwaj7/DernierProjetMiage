package fr.miage.toulouse.membersAdmin.services;

import fr.miage.toulouse.membersAdmin.model.Membre;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    Iterable<Membre> listerMembres();

    String promoteTeamLeader(Integer userID);

    Integer stats();

}
