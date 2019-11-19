package project2.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project2.models.Attendants;

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
}
