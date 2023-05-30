package TechK.boxservice.repositories.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import TechK.boxservice.data.entities.Box;

@Repository
public interface BoxMongoRepository  extends MongoRepository<Box, String>{

}
