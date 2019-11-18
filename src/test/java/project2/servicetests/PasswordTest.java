package project2.servicetests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project2.services.PasswordService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordTest {
	@Autowired
	PasswordService passServ;
	
	private String password = "mudkips";
	private byte[] salt;
	
	@Test
	public void testHashConsistency() {
		salt = passServ.genSalt();
		byte[] firstHash = passServ.genHash(salt, password);
		byte[] secondHash = passServ.genHash(salt, password);
		
		System.out.println(firstHash + " ----- " + secondHash);
		
		assertTrue("The PasswordService genHash() method should return the same hash each time given the same inputs.", Arrays.equals(firstHash, secondHash));
	}
	
	
	
}
