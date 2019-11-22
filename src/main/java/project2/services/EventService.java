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
import project2.entities.Users;
import project2.models.Planner;

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
	public int updateEvent(Planner party) {
		int id; // value of user_role_id
		//Call the attendant table
		id = attendDao.getRoleValue(party.getClientRequest().getEvent_id(), party.getUserId());
		
		//Check the permission of the attendant table
		if(id == 1) {
			eventRepo.updateEventDAO(party.getClientRequest());
			return 1; //return 1 on successful update
		}
		return 0;//return on failure user is not allow to edit this event
	}
	
	public int deleteEvent(Planner party) {
		int id;  // value of user_role_id
		//Call the attendant table
		id = attendDao.getRoleValue(party.getClientRequest().getEvent_id(), party.getUserId());
		
		//Check the permission of the attendant table
		if(id == 1) {
			attendDao.removeAttendants(party.getClientRequest().getEvent_id());
			eventRepo.deleteMyEvent(party.getClientRequest().getEvent_id());
			return 1; //return 1 on successful update
		}
		return 0; //return on failure user is not allow to edit this event
	}

	/**
	 * Returns a list of events that a given user_id is subscribed to
	 * @param userid
	 * @return
	 */
	public List<Event> getEventsByUserId(int userid) {
		List<Attendants> attends= attendDao.getAttendsListByUserId(userid);
		ArrayList<Integer> userids = new ArrayList<Integer>();
		  for(Attendants i: attends) {
			 userids.add(i.getEvent_id());
		}
		List<Event> events = eventRepo.getEventsByUserId(userids);
		
		return events;
	}

	/**
	 * Returns a list of events that a given user_id created
	 * @param userid
	 * @return
	 */
	public List<Event> getEventsByCreatorId(int userid) {
		List<Attendants> attends= attendDao.getAttendsListByCreatorId(userid);
		ArrayList<Integer> eventids = new ArrayList<Integer>();
		  for(Attendants i: attends) {
			 eventids.add(i.getEvent_id());
		}
		List<Event> events = eventRepo.getEventsByUserId(eventids);
		
		return events;
	}
}
