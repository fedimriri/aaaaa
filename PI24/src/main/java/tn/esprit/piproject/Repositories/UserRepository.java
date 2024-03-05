package tn.esprit.piproject.Repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.piproject.Entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {}
