package project2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2.models.Event;
import project2.repositories.EventRepository;

@Service
public class EventService {
	EventRepository eventRepo = new EventRepository();
	
	
	@Autowired
	public EventService(EventRepository eventRepo) {
		super();
		this.eventRepo = eventRepo;
	}


	@Transactional
	public Event createEvent(Event party) {
		return eventRepo.save(party);
	}

}
