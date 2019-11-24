package project2.controllertests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import project2.controls.EventController;
import project2.entities.Event;
import project2.models.Planner;
import project2.services.EventService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	EventService mockEventService;
	
	@InjectMocks
	private EventController eventController;
	
	@Autowired
	ObjectMapper om;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(eventController)
//		ExceptionHandlerAdvisor is a class in the 
//				.setControllerAdvice(new ExceptionHandlerAdvisor())
				.build();
	}
	
	@Test //TEST #1
	/**
	 * Test the controller to accept a JSON object and insert new
	 * event
	 * @throws Exception
	 */
	public void insertingNewEvent() throws Exception{
		//create dummy object to be tested with
		// id is not set since it will be auto generated
		Planner event = new Planner();
		Event party = new Event();
		event.setClientRequest(party);
		event.getClientRequest().setTitle("mockTitle1");
		event.getClientRequest().setType(2);
		event.getClientRequest().setDescription("mockDescription1");
		event.getClientRequest().setLocation("mockLocation1");
		event.getClientRequest().setAddress("mockAddress1");
		event.getClientRequest().setVisibility(3);
		event.getClientRequest().setImgAddr("mockPicture1");
		
		//Stubbing the implementation of the ___ method
		when(mockEventService.createEvent(event))
			.thenReturn(party);
		
		this.mockMvc.perform(post("/events/1")
			.contentType(MediaType.APPLICATION_JSON)
			.content(om.writeValueAsString(event)))
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().is(HttpStatus.CREATED.value()))
			.andDo(print());
		
	}
	
	@Test //TEST #2
	/**
	 * Test the controller to accept a JSON object 
	 * and update event
	 * @throws Exception
	 */
	public void updateEvent() throws Exception{
		//create dummy object to be tested with
		Planner event2 = new Planner();
		Event party2 = new Event();
		//frontend must send the event_id with the whole content of Event.class
		event2.setClientRequest(party2);
		event2.getClientRequest().setEvent_id(4);
		//following setting will update the old event with these new ones
		event2.getClientRequest().setTitle("mockTitle1");
		event2.getClientRequest().setType(2);
		event2.getClientRequest().setDescription("mockDescription1");
		event2.getClientRequest().setLocation("mockLocation1");
		event2.getClientRequest().setAddress("mockAddress1");
		event2.getClientRequest().setVisibility(3);
		event2.getClientRequest().setImgAddr("mockPicture1");
		
		//Stubbing the implementation of the updateEvent method
		when(mockEventService.updateEvent(event2))
			.thenReturn(1);//1 is success and 0 is failure
		
		this.mockMvc.perform(post("/events/2")
			.contentType(MediaType.APPLICATION_JSON)
			.content(om.writeValueAsString(event2)))
			.andExpect(status().is(HttpStatus.ACCEPTED.value()));
		
	}
	
	@Test //TEST #3
	/**
	 * Test the controller to take 
	 * Event object class
	 * @throws Exception
	 */
	public void deleteEvent() throws Exception{
		//create dummy object to be tested with
		Planner event3 = new Planner();
		Event party3 = new Event();
		//frontend must send the event_id
		event3.setClientRequest(party3);
		event3.getClientRequest().setEvent_id(4);
		
		//Stubbing the implementation of the updateEvent method
		when(mockEventService.deleteEvent(event3))
			.thenReturn(1);//1 is success and 0 is failure
		
		this.mockMvc.perform(post("/events/3")
			.contentType(MediaType.APPLICATION_JSON)
			.content(om.writeValueAsString(event3)))
			.andExpect(status().is(HttpStatus.OK.value()));
		
	}
}
