package project2.repositories;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project2.models.Event;

@Repository
public class EventRepository {
	
	Date date = new Date();
	
	@PersistenceContext
	@Autowired(required = true)
	EntityManager em;
	
	/**
	 * Saves a new event given new Event object.
	 * @param party
	 * @return
	 */
	public Event save(Event party) {
		Session eventsess = em.unwrap(Session.class);
		Event event = newEvent(party);
		
		eventsess.persist(event);
		
		
		return event;
	}
	
	/**
	 * Setup the Event object
	 * @param party
	 * @return
	 */
	private Event newEvent(Event party) {
		Event new_party = new Event();
		new_party.setTitle(party.getTitle());
		new_party.setType(party.getType());
		new_party.setCreated(new Timestamp(date.getTime()));
		new_party.setStartTime(party.getStartTime());
		new_party.setEndTime(party.getEndTime());
		new_party.setDescription(party.getDescription());
		new_party.setLocation(party.getLocation());
		new_party.setAddress(party.getAddress());
		new_party.setImgAddr(party.getImgAddr());
		new_party.setVisibility(party.getVisibility());
		return new_party;
	}

}
