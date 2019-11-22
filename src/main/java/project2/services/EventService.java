package project2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2.daos.AttendantDao;
import project2.daos.EventDao;
import project2.entities.Attendants;
import project2.entities.Event;

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

	
	/**
	 * Takes in Event object from the controllers and
	 * send it to the event DAOs (eventRepo)
	 * @param party: new event updates
	 * 
	 * @return What are we returning if
	 * 	the update is a success?
	 * 
	 * 	the update is a failure?
	 */
	public int updateEvent(Event party) {
		/* check the attendants table;
		 *	select * from the attendant table where event id and user id == 1 
		 *	if(permission id == 1) allow edit
		 *	else return null
		 */
		int id; // user id needed
		int currentUserId = 1;
		//Call the attendant table
		id = attendDao.getRoleValue(party.getEvent_id(), currentUserId);
		
		//Check the permission of the attendant table
		if(id == 1) {
			eventRepo.updateEventDAO(party);
			return 1; //return 1 on successful update
		}
		return 0;
	}
	
	public int deleteEvent(Event party) {
		int id; // user id needed
		int currentUserId = 1;
		//Call the attendant table
		id = attendDao.getRoleValue(party.getEvent_id(), currentUserId);
		
		//Check the permission of the attendant table
		if(id == 1) {
			attendDao.removeAttendants(party.getEvent_id());
			eventRepo.deleteMyEvent(party.getEvent_id());
			return 1; //return 1 on successful update
		}
		return 0;
	}


	public List<Event> getEventsByUserId(int userid) {
		List<Attendants> attends= attendDao.getAttendsListByUserId(userid);
		ArrayList<Integer> userids = new ArrayList<Integer>();
		  for(Attendants i: attends) {
			 userids.add(i.getEvent_id());
		}
		List<Event> events = eventRepo.getEventsByUserId(userids);
		
		return events;
	}

}
