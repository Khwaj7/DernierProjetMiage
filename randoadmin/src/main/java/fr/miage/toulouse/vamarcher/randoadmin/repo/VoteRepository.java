package fr.miage.toulouse.vamarcher.randoadmin.repo;

import fr.miage.toulouse.vamarcher.randoadmin.model.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends MongoRepository<Vote, String> {
}
