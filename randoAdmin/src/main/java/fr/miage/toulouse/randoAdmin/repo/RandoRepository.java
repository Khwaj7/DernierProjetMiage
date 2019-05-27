package fr.miage.toulouse.randoAdmin.repo;

import fr.miage.toulouse.randoAdmin.model.Rando;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RandoRepository extends MongoRepository<Rando, Integer> {
}
