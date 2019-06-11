package fr.miage.toulouse.membersAdmin.dao;

import fr.miage.toulouse.membersAdmin.model.TeamLeader;
import org.springframework.data.repository.CrudRepository;

public interface TeamLeaderDao extends CrudRepository<TeamLeader, Integer> {
}
