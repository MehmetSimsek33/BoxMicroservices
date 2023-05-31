package TechK.boxservice.service.abstracts.box.entity;

import java.util.List;

import org.springframework.stereotype.Service;

import TechK.boxservice.data.entities.Box;
import TechK.boxservice.repositories.mongodb.BoxMongoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoxMongoEntityManager implements BoxMongoEntityService {

	private BoxMongoRepository boxMongoRepository;



	@Override
	public void delete(String id) {
		this.boxMongoRepository.deleteById(id);
		;
	}

	@Override
	public Box update(Box box) {
		return this.boxMongoRepository.save(box);
	}

	@Override
	public List<Box> getAll() {
		return this.boxMongoRepository.findAll();
	}

	@Override
	public Box getById(String id) {
		return this.boxMongoRepository.findById(id).get();
	}

	@Override
	public Box save(Box box) {
		return this.boxMongoRepository.save(box);
	}

}
