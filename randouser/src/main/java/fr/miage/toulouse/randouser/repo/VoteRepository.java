package fr.miage.toulouse.randouser.repo;

import fr.miage.toulouse.randouser.model.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends MongoRepository<Vote, String> {
}
