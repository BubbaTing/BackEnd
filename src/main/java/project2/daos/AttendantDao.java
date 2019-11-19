package project2.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
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
	public Attendants getAttendantById(int id) {
		Session sess = em.unwrap(Session.class);
		Attendants attend = sess.get(Attendants.class, id);
		return attend;
	}

	public UserRoles getRoleById(int userroleid) {
		Session sess = em.unwrap(Session.class);
		return sess.get(UserRoles.class, userroleid);
	}

	public Permissions getPermissionsById(int permissions) {
		Session sess = em.unwrap(Session.class);
		return sess.get(Permissions.class, permissions);
	}

//	public int getMaxId() {
//		Session sess = em.unwrap(Session.class);
//		try {
//			int maxId = (int) sess.createQuery("SELECT max(attendant_id) from Attendants")
//					.getSingleResult();
//			return maxId;
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//			return 1;
//		}
//	}
}
