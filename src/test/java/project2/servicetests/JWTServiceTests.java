package project2.servicetests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project2.entities.Users;
import project2.services.JWTService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JWTServiceTests {
	
	@Autowired
	JWTService jwtserv;
	
	//Expired JWT
	String testJWS = "eyJhbGciOiJIUzUxMiJ9"
			+ ".eyJpc3MiOiJUZWFtVm9sZGVtb3J0Iiwic3ViIjoiSXJvbm1hbixPcmFuZ2UiLCJpYXQiOjE1NzQxMDQ1NjIsImV4cCI6MTU3NDEwMDk2MiwidXNlcklkIjozfQ"
			+ ".vmc3x_dEkCJ-eLoqjNDsADYNnJNipqH5awKgWcFmOd-HqqSRIY21t4FbrhWlrOEbDqhJLmbCb-ldDr53oknxEw";
	Users testUser  = new Users(1, "John", "Doe", "johndoe@exmaple.com", null, null, null, null, null);
	
	@Test
	public void testCreateJWT() {
		String jwt = jwtserv.signJWT(testUser);
		System.out.println("JWT Generated: " + jwt);
		assertTrue("The createJWT() method should return a JWT string when called.", jwt != null);
	}
	
	@Test 
	public void testValidateJWT() {
		String jwt = jwtserv.signJWT(testUser);
		assertTrue("The validateJWT() method should return true for valid JWT", jwtserv.validateJWT(jwt));
	}
	
	@Test 
	public void testValidateJWTWithId() {
		String jwt = jwtserv.signJWT(testUser);
		assertTrue("The validateJWT() method should return true for a valid JWT and userId combination", jwtserv.validateJWT(jwt, 1));
	}
	
	@Test 
	public void testValidateJWTWithWrongId() {
		String jwt = jwtserv.signJWT(testUser);
		assertFalse("The validateJWT() method should return true for a valid JWT and userId combination", jwtserv.validateJWT(jwt, 2));
	}
	
	@Test
	public void testExpiredJWT() {
		assertFalse("The validateJWT() method should return false for expired JWT", jwtserv.validateJWT(testJWS));
	}
	
}
