package tn.esprit.piproject.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.piproject.Entities.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, Integer> {}
