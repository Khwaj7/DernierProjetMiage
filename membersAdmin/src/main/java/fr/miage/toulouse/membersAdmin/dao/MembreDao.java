package fr.miage.toulouse.membersAdmin.dao;

import fr.miage.toulouse.membersAdmin.model.Membre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MembreDao extends CrudRepository<Membre, Integer> {
    @Query("SELECT m FROM Membre m WHERE m.login=:login")
    Membre findByLogin(@Param("login") String login);
}
