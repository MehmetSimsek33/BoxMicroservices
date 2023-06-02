package TechK.identityservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TechK.common.utilities.results.DataResult;
import TechK.identityservice.data.entity.AuthModel;
import TechK.identityservice.data.request.UserRequest;
import TechK.identityservice.jwt.JwtResponse;
import TechK.identityservice.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public DataResult<JwtResponse> logins(@RequestBody AuthModel authModel) {
		return this.userService.login(authModel);			
	}	

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> registerAuthor(
            @RequestBody UserRequest request
    ){
        return ResponseEntity.ok(userService.registerAuthor(request));
    }

    @PostMapping("register/publisher")
    public ResponseEntity<JwtResponse> registerPublisher(
            @RequestBody UserRequest request
    ){
        return ResponseEntity.ok(userService.registerPublisher(request));
    }
}