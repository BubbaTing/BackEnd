package project2.daos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
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

	public int updateEventDAO(Event party) {
		Session eventsess = em.unwrap(Session.class);
		Transaction trans = eventsess.beginTransaction();
		
		Event event = eventsess.get(Event.class, party.getEvent_id());
		System.out.println("Before updating...");
		event.setDescription(party.getDescription());
		eventsess.update(event);//saveorUpdate(party);
		System.out.println("Updated");
		trans.commit();
//		String hql = ("update Event "
//				+ "set address=:p.address"
//				+ "set created=:p.created"
//				+ "set description=:p.description"
//				+ "set end_time=:p.end_time"
//				+ "set img_addr=:p.img_address"
//				+ "set location=:p.location"
//				+ "set start_time=:p.start_time"
//				+ "set type=:p.type"
//				+ "set visbility=:p.visbility"
//				+ "set title=:p.title"
//				+ "where event_id=:p.eventid");
//		Query myEvent = (Query) em.createQuery(hql, Event.class)
//				.setParameter("p.address", party.getAddress())
//				.setParameter("p.created", party.getCreated())
//				.setParameter("p.description", party.getDescription())
//				.setParameter("p.end_time", party.getEndTime())
//				.setParameter("p.img_address", party.getImgAddr())
//				.setParameter("p.location", party.getLocation())
//				.setParameter("p.start_time", party.getStartTime())
//				.setParameter("p.type", party.getType())
//				.setParameter("p.visbility", party.getVisibility())
//				.setParameter("p.title", party.getTitle())
//				.setParameter("p.eventid", party.getEvent_id())
//				.getResultList();
//		int result = myEvent.executeUpdate();
		return 1; //result;
	}



}
