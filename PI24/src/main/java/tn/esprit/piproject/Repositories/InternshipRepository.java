package tn.esprit.piproject.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.piproject.Entities.Internship;

@Repository
public interface InternshipRepository extends MongoRepository<Internship, Integer> {}
