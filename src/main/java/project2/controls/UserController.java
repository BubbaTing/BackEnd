package project2.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project2.models.Credentials;
import project2.models.Users;
import project2.services.UserService;


@RestController
@RequestMapping("users")
public class UserController {
	
	UserService userService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Users createUser (@RequestBody Credentials cred) {
		System.out.println("Starting POST method.");
		return userService.createUser(cred);
	}
	
	@Autowired
	public UserController(UserService userServ) {
		super();
		this.userService = userServ;
	}
}
