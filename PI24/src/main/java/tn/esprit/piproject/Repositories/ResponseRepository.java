package tn.esprit.piproject.Repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.piproject.Entities.Response;

@Repository
public interface ResponseRepository extends MongoRepository<Response, Integer> {}