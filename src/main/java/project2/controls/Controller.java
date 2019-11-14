package project2.controls;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project2.models.User;
import project2.services.UserService;


@RestController
@RequestMapping("users")
public class Controller {
	
	UserService userService;
	
	@PostMapping
	public User createUser (@RequestBody @Valid User user) {
		return userService.createUser(user);
	}
}
