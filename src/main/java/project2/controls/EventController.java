package project2.controls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project2.entities.Event;
import project2.models.Planner;
import project2.services.EventService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("events/*")
public class EventController {

	EventService eventService;

	@Autowired
	public EventController(EventService partyService) {
		super();
		this.eventService = partyService;
	}

	//1 ==> Create Event
	@PostMapping("/1")
	@ResponseStatus(HttpStatus.CREATED)
	public Event createEvent(@RequestBody Event party) {
		System.out.println("Event Created in Progress");
		return eventService.createEvent(party);
	}
	
	//2 ==> Update Event
	/**
	 * Accepts an event, returns a 1 on successful write or a 0 on a failed write
	 * @param party
	 * @return
	 */
	@PostMapping("/2")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public int updateMyEvent(@RequestBody Planner party) {
		System.out.println("Event Updated in Progress");
		return eventService.updateEvent(party);
	}
	
	//3 ==> Delete Event
	/**
	 * Accepts an event, returns a 1 on successful deletion or a 0 on a failed deletion
	 * @param party
	 * @return
	 */
	@PostMapping("/3")
	@ResponseStatus(HttpStatus.OK)
	public int deleteMyEvent(@RequestBody Planner party) {
		System.out.println("Event Updated in Progress");
		return eventService.deleteEvent(party);
	}
	
	//4 ==> Return Events given UserID
	/**
	 * Returns a list of events that a given user_id is attending.
	 */
	@GetMapping("/4/{userid}")
	@ResponseStatus(HttpStatus.OK)
	public List<Event> getEventsByUserId(@PathVariable int userid){
		
		System.out.println("Retrieving Events by UserId...");
		return eventService.getEventsByUserId(userid);
	}
	
	//5 ==> Returns the list of Events a user created
	/**
	 * Returns a list of events that a given user_id created.
	 */
	@GetMapping("/5/{userid}")
	@ResponseStatus(HttpStatus.OK)
	public List<Event> getEventsByCreatorId(@PathVariable int userid){
		System.out.println("Retrieving Events by CreatorId...");
		return eventService.getEventsByCreatorId(userid);
	}
}
