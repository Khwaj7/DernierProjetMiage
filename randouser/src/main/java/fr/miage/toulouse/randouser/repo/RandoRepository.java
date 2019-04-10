package fr.miage.toulouse.randouser.repo;

import fr.miage.toulouse.randouser.model.Rando;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RandoRepository extends MongoRepository<Rando, Integer> {
}
