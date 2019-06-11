package fr.miage.toulouse.membersAdmin.dao;

import fr.miage.toulouse.membersAdmin.model.Membre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MembreDao extends CrudRepository<Membre, Integer> {
}
