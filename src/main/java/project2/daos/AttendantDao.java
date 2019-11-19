package project2.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project2.entities.Attendants;

@Component
public class AttendantDao {
	
	@PersistenceContext
	@Autowired (required = true)
	EntityManager em;
	
	public Attendants saveAttendant(Attendants attend) {
		Session sess = em.unwrap(Session.class);
		sess.persist(attend);
		return attend;
	}

	//TODO
	/**
	 * Returns an array of attendants objects given a userid
	 * @param id
	 * @return
	 */
	public Attendants getAttendantById(int id) {
		Session sess = em.unwrap(Session.class);
		Attendants attend = sess.get(Attendants.class, id);
		return attend;
	}

	/**
	 * By Chong
	 * 
	 * @param event_id
	 * @param currentUserId
	 * @return
	 */
	
	public int getPermissionValue(int currentEventId, int currentUserId) {
		int value;
		Session sessPermission = em.unwrap(Session.class);
		
		String hql = "Select A.user_role_id from Attendant A"
				+ " where A.event_id = :currentEventId and"
				+ " A.user_id = :currentUserId";
				
		Query query = sessPermission.createQuery(hql);
		
		value = query.
		
		return value;
	}
}
