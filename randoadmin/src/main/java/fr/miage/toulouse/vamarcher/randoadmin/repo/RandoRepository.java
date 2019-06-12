package fr.miage.toulouse.vamarcher.randoadmin.repo;

import fr.miage.toulouse.vamarcher.randoadmin.model.Rando;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface RandoRepository extends MongoRepository<Rando, String> {
    @Query("{'id' : ?0}")
    Rando findbyRandoId(String randoID);
}
