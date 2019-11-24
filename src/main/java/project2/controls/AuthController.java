package project2.controls;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project2.entities.Users;
import project2.models.Credentials;
import project2.models.UserResponse;
import project2.services.JWTService;
import project2.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("auth")
public class AuthController {

    UserService userService;
    JWTService jwtServ;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public UserResponse authCredentials(@RequestBody Credentials cred, HttpServletResponse response) {
        System.out.println("Attempting User Auth...");
        Users user = userService.getUserByCred(cred);
        if(user != null) {
        	UserResponse uresp = new UserResponse(user);
        	uresp.setJwt(jwtServ.signJWT(user));
        	return uresp;
        } 
        return null;
    }

    @Autowired
    public AuthController(UserService userServ, JWTService jwtServ) {
        super();
        this.userService = userServ;
        this.jwtServ = jwtServ;
    }
}
