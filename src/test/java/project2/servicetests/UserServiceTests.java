package project2.servicetests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project2.entities.Users;
import project2.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	UserService userServ;
	
	private int testUserId = 1;
	
	@Test
	public void testGetUserById() {
		Users user = userServ.getUserById(testUserId);
		System.out.println("User Fetched: " + user.toString());
		assertTrue("Userservice.getUserById() should return a user with one inside the database (with user_id of 1).", user != null);
	}
}
