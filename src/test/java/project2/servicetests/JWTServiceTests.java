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
	
	//Testing JWT
	String testJWS = "eyJhbGciOiJIUzUxMiJ9"
			+ ".eyJpc3MiOiJUZWFtVm9sZGVtb3J0Iiwic3ViIjoiSXJvbm1hbixPcmFuZ2UiLCJpYXQiOjE1NzQxMDQ1NjIsImV4cCI6MTU3NDEwMDk2MiwidXNlcklkIjozfQ"
			+ ".vmc3x_dEkCJ-eLoqjNDsADYNnJNipqH5awKgWcFmOd-HqqSRIY21t4FbrhWlrOEbDqhJLmbCb-ldDr53oknxEw";
	Users testUser  = new Users(1, null, "John", "Doe", "johndoe@exmaple.com", null, null, null, null, null);
	
	@Test
	public void testCreateJWT() {
		String jwt = jwtserv.signJWT(testUser);
		System.out.println("JWT Generated: " + jwt);
		assertTrue("The createJWT() method should return a JWT string when called.", jwt != null);
	}
	
	@Test 
	public void testValidateJWT() {
		String jwt = jwtserv.signJWT(testUser);
		assertTrue("The readJWTUserId() method should return true for valid JWT", jwtserv.validateJWT(jwt));
	}
}
