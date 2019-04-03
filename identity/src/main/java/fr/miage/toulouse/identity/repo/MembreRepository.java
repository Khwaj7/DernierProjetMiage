package fr.miage.toulouse.identity.repo;

import fr.miage.toulouse.identity.metier.Membre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembreRepository extends CrudRepository<Membre, Integer>{

}
