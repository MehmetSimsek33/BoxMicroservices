package TechK.boxservice.data.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBoxResponse {
	

	private String id;
	private String boxType;
	private int state;
}
  