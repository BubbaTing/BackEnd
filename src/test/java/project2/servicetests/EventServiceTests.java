package project2.servicetests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import project2.entities.Event;
import project2.services.EventService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceTests {
		
	@Autowired
	EventService eventServ;
		
	private int testEventId = 1;
		
	@Test
	public void testGetEventById() {
		Event event = eventServ.getEventById(testEventId);
		System.out.println("Event Fetched: " + event.toString());
		assertTrue("EventService.getUserById() should return an event with one inside the database. (with event_id of 1).", event != null);
	}
	
}
