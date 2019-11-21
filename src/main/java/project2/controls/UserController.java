package project2.controls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project2.entities.Attendants;
import project2.entities.Event;
import project2.entities.Users;
import project2.models.UserRegistration;
import project2.models.UserResponse;
import project2.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("users/*")
public class UserController {

    UserService userService;

    @PostMapping("users/1")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRegistration regreq) {
        System.out.println("Attempting User Write...");
        Users user = userService.createUser(regreq);
        return new UserResponse(user);
    }
	
	@GetMapping("users/2")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Users> getUsersByEventId(@RequestBody int eventid) {
        System.out.println("Attempting []User Read...");
        List<Users> users = userService.getAttendantsByEventId(eventid);
        return users;
    }

    @Autowired
    public UserController(UserService userServ) {
        super();
        this.userService = userServ;
    }
    
	//2 ==> getting the number of attendants per event
	@PostMapping("users/2")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<Users> numberOfAttendantsPerEvent(@RequestBody int party) {
		System.out.println("Event Updated in Progress");
		return userService.findNumberOfAttendants(party);
	}
    
    
}
