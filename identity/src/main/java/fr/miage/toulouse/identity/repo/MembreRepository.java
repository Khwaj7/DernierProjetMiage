package fr.miage.toulouse.identity.repo;

import fr.miage.toulouse.identity.metier.Membre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembreRepository extends CrudRepository<Membre, Integer>{

    @Query("SELECT m FROM Membre m WHERE m.login=:login")
    Membre findByLogin(@Param("login") String login);

}
