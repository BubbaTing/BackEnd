package project2.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import project2.entities.Event;

import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project2.entities.Attendants;
import project2.entities.Permissions;
import project2.entities.UserRoles;

@Component
public class AttendantDao {

	@PersistenceContext
	@Autowired (required = true)
	EntityManager em;

	public Attendants saveAttendant(Attendants attend) {
		Session sess = em.unwrap(Session.class);
		sess.save(attend);
		return attend;
	}

	//TODO
	/**
	 * Returns an array of attendants objects given a userid
	 * @param id
	 * @return
	 */
	public Attendants getAttendantsById(int id) {
		Session sess = em.unwrap(Session.class);
		Attendants attend = sess.get(Attendants.class, id);
		return attend;
	}

	/**
	 * Returns RoleId object where user_role_id = input
	 * @param userroleid
	 * @return
	 */
	public UserRoles getRoleById(int userroleid) {
		Session sess = em.unwrap(Session.class);
		return sess.get(UserRoles.class, userroleid);
	}

	/**
	 * Returns Permissions object where permissions_id = input
	 * @param permissions
	 * @return
	 */
	public Permissions getPermissionsById(int permissions) {
		Session sess = em.unwrap(Session.class);
		return sess.get(Permissions.class, permissions);
	}

	/**
	 * Returns ArrayList<Attendants> where user_id = input
	 * @param userid
	 * @return
	 */
	public List<Attendants> getAttendsByUserId(int userid) {
		String hql = ("FROM Attendants WHERE user_id=:userid");
		List<Attendants> attend = em.createQuery(hql, Attendants.class)
						.setParameter("userid", userid)
						.getResultList();
		return attend;
	}
		
	/**
	 * By Chong 
	 * @param currentEventId
	 * @param currentUserId
	 * @return
	 */
	public int getRoleValue(int currentEventId, int currentUserId){
		int value;
		Session sessPermission = em.unwrap(Session.class);
		
		String hql = "SELECT user_role_id FROM Attendants"
				+ " WHERE event_id=:currentEventId and"
				+ " user_id=:currentUserId";
				
		List<Event> query = sessPermission.createQuery(hql)
				.setParameter("currentEventId", currentEventId)
				.setParameter("currentUserId", currentUserId)
				.getResultList();
		
		System.out.println("This Role Value is" + query.toString());
		
		value = 1; //(int) query.uniqueResult();
		 
		return value;
	}
	


}
