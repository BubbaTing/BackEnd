package project2.controllertests;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import project2.controls.UserController;
import project2.entities.Event;
import project2.entities.Users;
import project2.models.UserRegistration;
import project2.models.UserResponse;
import project2.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

		
	private MockMvc mokMvc;
	
	@Mock
	UserService userServiceTest;
	
	@InjectMocks
	private UserController userController;
	
	@Autowired
	ObjectMapper om;
	
	@Before 
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mokMvc = MockMvcBuilders.standaloneSetup(userController)
				.build();
	}
	
	@Test
	public void CreateNewUser() throws Exception{
		UserResponse user = new UserResponse();
		UserRegistration regreq = new UserRegistration();
		regreq.setFirstName("mock first name");
		regreq.setLastName("mock last name");
		regreq.setPassword("mock password");
		regreq.setConfirmPassword("mock password");
		regreq.setAvatar_url("mock pic link");
		
		user.setFirstname(regreq.getFirstName());
		user.setEmail(regreq.getEmail());
		user.setUserid(1);
		user.setAvatar(regreq.getAvatar_url());
		user.setJwt("mock value");
		
		when(userServiceTest.createUser(regreq))
		.thenReturn(user);
		
		this.mokMvc.perform(post("/users/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(regreq)))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is(HttpStatus.CREATED.value()))
		.andDo(print());
	
	}
	
	@Test
	public void numberOfAttendantsPerEventTest() throws Exception{
		List<Users> user = new ArrayList<Users>();
		Event event = new Event();
		event.setEvent_id(4);
		when(userServiceTest.findNumberOfAttendants(event.getEvent_id()))
		.thenReturn(user);
		
		this.mokMvc.perform(post("/users/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(event.getEvent_id())))
				.andExpect(status().is(HttpStatus.ACCEPTED.value()));
	}
	
}
