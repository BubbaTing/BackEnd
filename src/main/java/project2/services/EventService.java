package project2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2.daos.EventDao;
import project2.models.Event;

@Service
public class EventService {
	EventDao eventRepo = new EventDao();
	
	
	@Autowired
	public EventService(EventDao eventRepo) {
		super();
		this.eventRepo = eventRepo;
	}


	@Transactional
	public Event createEvent(Event party) {
		return eventRepo.save(party);
	}

}
