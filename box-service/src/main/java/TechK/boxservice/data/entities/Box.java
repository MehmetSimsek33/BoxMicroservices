package TechK.boxservice.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("boxes")
@Data
public class Box {

	@Id
	private String id; 
	private String boxType;
	private int state;

}
