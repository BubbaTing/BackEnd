package project2.daos;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;

import project2.models.Credentials;
import project2.models.User;
import project2.services.PasswordService;
import project2.utils.HibernateUtil;

public class UserDao {
	Date date = new Date();
	PasswordService passServ = new PasswordService();
	
	/**
	 * Saves a new user given new Credentials. Returns null if the password and confirmed password do not match
	 * @param cred
	 * @return
	 */
	public User save(Credentials cred) {
		if (cred.getPassword() != cred.getConfirmPassword()) return null;
		try(Session sess = HibernateUtil.sessionFactory.openSession()) {
			User user = newUser(cred);
			byte[] salt = passServ.genSalt();
			byte[] hash = passServ.genHash(salt, cred.getPassword());
			user.setPassword(hash);
			user.setSalt(salt);
			
			sess.save(user);
			
			return user;
		}
	}
	
	/**
	 * Creates a new user given a Credentials object
	 */
	private User newUser(Credentials cred) {
		User user = new User();
		user.setCreatedDate(new Timestamp(date.getTime()));
		user.setEmail(cred.getEmail());
		user.setFirstname(cred.getFirstname());
		user.setLastname(cred.getLastname());
		return user;
	}
}
