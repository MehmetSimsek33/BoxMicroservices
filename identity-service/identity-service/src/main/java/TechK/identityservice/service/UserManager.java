package TechK.identityservice.service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import TechK.common.utilities.exceptions.BusinessExcaption;
import TechK.common.utilities.results.DataResult;
import TechK.common.utilities.results.SuccessDataResult;
import TechK.identityservice.data.entity.AuthModel;
import TechK.identityservice.data.entity.Roles;
import TechK.identityservice.data.entity.User;
import TechK.identityservice.data.request.UserRequest;
import TechK.identityservice.jwt.JwtResponse;
import TechK.identityservice.jwt.JwtTokenUtil;
import TechK.identityservice.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenUtil jwtTokenUtil;
	private final AuthenticationManager authenticationManager;


    
    private User.UserBuilder register(UserRequest request){
		if (userRepository.existsByEmail(request.getEmail())) {
		throw new BusinessExcaption("User is already register with email:" + request.getEmail());
	}
        return User.builder()
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()));
    }
	

	public JwtResponse registerAuthor(UserRequest request) {
		var user = register(request).roles(Roles.AUTHOR).build();
		userRepository.save(user);
		var jwtToken = jwtTokenUtil.generateToken(user);
		return JwtResponse.builder().accessToken(jwtToken).build();
	}

	public JwtResponse registerPublisher(UserRequest request) {
		var user = register(request).roles(Roles.ADMIN).build();
		userRepository.save(user);
		var jwtToken = jwtTokenUtil.generateToken(user);
		return JwtResponse.builder().accessToken(jwtToken).build();
	}

	@Override
	public User getByUserId() {
		String userId = getLoggedInUser().getId();
		return userRepository.findById(userId).orElseThrow(() -> new BusinessExcaption("User not found id " + userId));
	}

	@Override
	public User update(User user) {
		User oUser = getByUserId();
		oUser.setFirstname(user.getFirstname() != null ? user.getFirstname() : oUser.getFirstname());
		oUser.setEmail(user.getEmail() != null ? passwordEncoder.encode(user.getPassword()) : oUser.getEmail());
		oUser.setPassword(user.getPassword() != null ? user.getEmail() : oUser.getPassword());
		oUser.setLastname(user.getLastname() != null ? user.getLastname() : oUser.getLastname());

		return userRepository.save(oUser);
	}

	@Override
	public void delete() {
		User user = getByUserId();
		userRepository.delete(user);
	}

	public DataResult<JwtResponse> login(AuthModel authModel) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authModel.getEmail(), authModel.getPassword()));
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authModel.getEmail(), authModel.getPassword()));
		User user = userRepository.findByEmail(authModel.getEmail()).orElseThrow();
		var jwtToken = jwtTokenUtil.generateToken(user);
		return new SuccessDataResult<JwtResponse>(JwtResponse.builder().accessToken(jwtToken).build());
	}

	@Override
	public User getLoggedInUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not found the email" + email));

	}

}