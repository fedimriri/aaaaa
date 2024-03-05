package tn.esprit.piproject.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.piproject.Entities.Complaint;

@Repository
public interface ComplaintRepository extends MongoRepository<Complaint, Integer> {}