package TechK.boxservice.service.abstracts.box.entity;

import java.util.List;

import TechK.boxservice.data.entities.Box;

public interface BoxMongoEntityService {
	void delete(String id);
	Box update(Box box);
	List<Box> getAll();
	Box getById(String id);
	Box save(Box box);
}
