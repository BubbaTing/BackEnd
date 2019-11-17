package project2.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project2.models.Credentials;
import project2.services.JWTService;
import project2.services.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {
	
	UserService userService;
	JWTService jwtServ;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void authCredentials(@RequestBody Credentials cred) {
		System.out.println("Attempting User Auth...");
		userService.getUserByCred(cred);
	}
	
	@Autowired
	public AuthController(UserService userServ, JWTService jwtServ) {
		super();
		this.userService = userServ;
		this.jwtServ = jwtServ;
	}
}
