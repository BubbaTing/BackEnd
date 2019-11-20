package project2.daos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project2.entities.Attendants;
import project2.entities.Event;

@Component
public class EventDao {
	
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
		new_party.setStartTime(new Timestamp(date.getTime()));
		new_party.setEndTime(new Timestamp(date.getTime()));
		new_party.setDescription(party.getDescription());
		new_party.setLocation(party.getLocation());
		new_party.setAddress(party.getAddress());
		new_party.setImgAddr(party.getImgAddr());
		new_party.setVisibility(party.getVisibility());
		return new_party;
	}

	/** 
	 * Returns an event given an id.
	 * @param id
	 * @return
	 */
	public Event getEventById(int id) {
		Session sess = em.unwrap(Session.class);
		return sess.get(Event.class, id);
	}

	//TODO - relies on Attendants table
	/**
	 * Returns a list of Events given a userid
	 * @param id
	 * @return
	 */
	public ArrayList<Event> getUsersEvents(int id) {
		Session sess = em.unwrap(Session.class);
		
		return null;
	}
	
	
	
	public void updateThisEvent(int myEventId) {
		String hql = ("FROM Event WHERE Event_id=:myEventId");
		
		List<Event> myEvent = em.createQuery(hql, Event.class)
				.setParameter("myEventId", myEventId)
				.getResultList();
		//return myEvent;
		
		System.out.println("This updated query is" + myEvent.toString());
	}

	public Event updateEventDAO(Event party) {
		Session eventsess = em.unwrap(Session.class);
		
		eventsess.update(party);
		return null;
	}



}
