package project2.daos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		
		System.out.println("Dao Saving Event: " + event.toString());		
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

	/**
	 * Returns a list of Events given a userid
	 * @param id
	 * @return
	 */
	public ArrayList<Event> getUsersEvents(int id) {
		Session sess = em.unwrap(Session.class);
		
		return null;
	}

	/**
	 * Update the event row with the input party
	 * @param party
	 */
	public void updateEventDAO(Event party) {
		Session eventsess = em.unwrap(Session.class);
		Transaction trans = eventsess.beginTransaction();
		
		Event event = eventsess.get(Event.class, party.getEvent_id());
		System.out.println("Before updating...");
		event.setTitle(party.getTitle());
		event.setAddress(party.getAddress());
		//event.setCreated(party.getCreated());
		event.setStartTime(party.getStartTime());
		event.setEndTime(party.getEndTime());
		//event.setImgAddr(party.getImgAddr());
		event.setDescription(party.getDescription());
		event.setType(party.getType());
		event.setVisibility(party.getVisibility());
		
		eventsess.update(event);//saveorUpdate(party);
		System.out.println("Updated");
		trans.commit();
	}
	
	/**
	 * Deletes an Event given its event_id (and only the event, don't forget to delete the attendants!)
	 * @param myEventId
	 */
	public void deleteMyEvent(int myEventId) {
		 Session eventsess = em.unwrap(Session.class);
		 //Start Transaction
		 Transaction trans = eventsess.beginTransaction();
		 Event event = eventsess.get(Event.class, myEventId);
		 event.setEvent_id(myEventId);
		 eventsess.delete(event);
		 trans.commit();
		 System.out.println("this event deleted " + myEventId);
	}

	/**
	 * Returns a list of events given an ArrayList<Integers> containing user_id's. Used inside of EventService.getEventsByUserId()
	 * @param userid
	 * @return
	 */
	public List<Event> getEventsByUserId(ArrayList<Integer> eventids) {
		try {
			String hql = "FROM Event WHERE event_id IN :eventIds";
			List<Event> events = em.createQuery(hql, Event.class)
					.setParameter("eventIds", eventids)
					.getResultList();
			return events;  
		} catch (NullPointerException e){
			e.printStackTrace();
			return null;
		}
	}



}
