package project2.controllertests;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.Date;

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

	private Object mockMvc;
	
	@Before 
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mokMvc = MockMvcBuilders.standaloneSetup(userController)
				.build();
	}
	
	@Test
	public void CreateNewUser() throws Exception{
		Users user = new Users();
		Date date = new Date();
		UserRegistration regreq = new UserRegistration();
		user.setCreatedDate(new Timestamp(date.getTime()));
		user.setFirstname(regreq.getFirstName());
		user.setLastname(regreq.getLastName());
		user.setEmail(regreq.getEmail());
		user.setAvatarURL(regreq.getAvatar_url());
		when(userServiceTest.createUser(regreq))
		.thenReturn(user);
		
		this.mokMvc.perform(post("/users/1")
		.contentType(MediaType.APPLICATION_JSON)
		.content(om.writeValueAsString(user)))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is(HttpStatus.CREATED.value()))
		.andDo(print());
	
	}
	/*
	@Test
	private void numberOfAttendantsPerEventTest() throws Exception{
		
		Event event = new Event();
		event.setEvent_id(4);
		when(userServiceTest.findNumberOfAttendants(4))
		.thenCallRealMethod();
		
		((MockMvc) this.mockMvc).perform(post("/users/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(event)))
				.andExpect(status().is(HttpStatus.OK.value()));
	}
	*/
}
