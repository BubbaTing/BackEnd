package project2.repositories;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project2.models.Credentials;
import project2.models.Users;
import project2.services.PasswordService;

@Repository
public class UserRepository{
	
	Date date = new Date();
	
	@Autowired 
	PasswordService passServ;
	
	@PersistenceContext
	@Autowired (required = true)
	EntityManager em;

	/**
	 * Saves a new user given new Credentials. Returns null if the password and confirmed password do not match
	 * @param cred
	 * @return
	 */
	public Users save(Credentials cred) {
			System.out.println(em.toString());
			Session sess = em.unwrap(Session.class);
			System.out.println("Saving User...");
			Users user = newUser(cred);
			byte[] salt = passServ.genSalt();
			byte[] hash = passServ.genHash(salt, cred.getPassword());
			user.setPassword(hash);
			user.setSalt(salt);
			
			sess.persist(user);
			return user;
	}
	
	/**
	 * Creates a new user given a Credentials object
	 */
	private Users newUser(Credentials cred) {
		Users user = new Users();
		user.setCreatedDate(new Timestamp(date.getTime()));
		user.setEmail(cred.getEmail());
		user.setFirstname(cred.getFirstname());
		user.setLastname(cred.getLastname());
		return user;
	}
}
