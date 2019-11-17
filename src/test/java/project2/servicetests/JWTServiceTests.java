package project2.servicetests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project2.models.Users;
import project2.services.JWTService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JWTServiceTests {
	
	@Autowired
	JWTService jwtserv;
	
	Users testUser  = new Users(1, null, "John", "Doe", "johndoe@exmaple.com", null, null, null, null, null);
	
	@Test
	public void testCreateJWT() {
		String jwt = jwtserv.createJWT(testUser);
		System.out.println("JWT Generated: " + jwt);
		assertTrue("The createJWT() method should return a JWT string when called.", jwt != null);
	}
}
