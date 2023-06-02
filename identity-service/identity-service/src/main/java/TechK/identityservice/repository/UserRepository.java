package TechK.identityservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import TechK.identityservice.data.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	Boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);
}