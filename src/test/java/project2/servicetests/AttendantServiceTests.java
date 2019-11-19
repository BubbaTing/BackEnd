package project2.servicetests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project2.entities.Attendants;
import project2.services.AttendantService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendantServiceTests {

	@Autowired
	AttendantService attendServ;
	
	private int testAttendId = 1;
	
	@Test
	public void testGetAttendByUserId() {
		List<Attendants> attends = attendServ.getAttendsByUserId(testAttendId);
		System.out.println("Attendant Fetched: " + attends.toString());
		assertTrue("AttendsService.getAttendByUserId() should return some attendants from database (with user_id of 1).", attends != null);
	}
}
