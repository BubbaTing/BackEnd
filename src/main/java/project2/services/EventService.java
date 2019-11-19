package project2.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2.daos.AttendantDao;
import project2.daos.EventDao;
import project2.models.Event;

@Service
public class EventService {
	EventDao eventRepo;
	AttendantDao attendDao;
	
	
	@Autowired
	public EventService(EventDao eventRepo, AttendantDao attendDao) {
		super();
		this.eventRepo = eventRepo;
		this.attendDao = attendDao;
	}


	@Transactional
	public Event createEvent(Event party) {
		return eventRepo.save(party);
	}
	
	@Transactional
	public Event getEventById(int id ) {
		return eventRepo.getEventById(id);
	}
	
	//TODO - relies on Attendants Table
	/**
	 * Returns an arraylist of Events given a userID
	 * @param id
	 * @return
	 */
	@Transactional
	public ArrayList<Event> getUsersEvents(int id ){
		return eventRepo.getUsersEvents(id);
	}

}
