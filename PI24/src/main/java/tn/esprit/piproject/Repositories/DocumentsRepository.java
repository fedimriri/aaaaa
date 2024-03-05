package tn.esprit.piproject.Repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.piproject.Entities.Documents;

@Repository
public interface DocumentsRepository extends MongoRepository<Documents, Integer> {}