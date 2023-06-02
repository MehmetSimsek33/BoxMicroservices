package TechK.identityservice.service;

import TechK.common.utilities.results.DataResult;
import TechK.identityservice.data.entity.AuthModel;
import TechK.identityservice.data.entity.User;
import TechK.identityservice.data.request.UserRequest;
import TechK.identityservice.jwt.JwtResponse;

public interface UserService {

	User getLoggedInUser();

	// JwtResponse createUser(UserRequest request);
	JwtResponse registerPublisher(UserRequest request);

	JwtResponse registerAuthor(UserRequest request);

	DataResult<JwtResponse> login(AuthModel authModel);

	User getByUserId();

	User update(User user);

	void delete();
}