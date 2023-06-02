package TechK.identityservice.data.request;

import lombok.Data;

@Data
public class UserRequest {

	private String firstName;

	private String password;

	private String lastName;

	private String email;
	
}