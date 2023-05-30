package TechK.boxservice.data.requests.box;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBoxRequest {
	private String id;
	private String boxType;
	private int state;
}
