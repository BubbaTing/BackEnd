package project2.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project2.models.Credentials;
import project2.models.UserResponse;
import project2.models.Users;
import project2.services.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {
	
	UserService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public UserResponse authCredentials(@RequestBody Credentials cred) {
		System.out.println("Attempting User Auth...");
		Users user = userService.getUserByCred(cred);
		UserResponse uresp = new UserResponse(user);
		return uresp;
	}
	
	@Autowired
	public AuthController(UserService userServ) {
		super();
		this.userService = userServ;
	}
}
