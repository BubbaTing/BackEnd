package project2.controls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project2.entities.Event;
import project2.services.EventService;

@RestController
@RequestMapping("events/*")
public class EventController {

	EventService eventService;

	@Autowired
	public EventController(EventService partyService) {
		super();
		this.eventService = partyService;
	}

	//1 ==> Create Event
	@PostMapping("events/1")
	@ResponseStatus(HttpStatus.CREATED)
	public Event createEvent(@RequestBody Event party) {
		System.out.println("Event Created in Progress");
		return eventService.createEvent(party);
	}
	
	//2 ==> Update Event
	@PostMapping("events/2")
	public Event updateEvent(@RequestBody Event party) {
		System.out.println("Event Updated in Progress");
		return eventService.updateEvent(party);
	}

}
