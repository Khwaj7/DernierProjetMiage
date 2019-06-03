package fr.miage.toulouse.randouser.repo;

import fr.miage.toulouse.randouser.model.Rando;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RandoRepository extends MongoRepository<Rando, String> {
    @Query("{'id' : ?0}")
    Rando findbyRandoId(String randoID);
}