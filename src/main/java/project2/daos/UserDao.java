package project2.daos;

import org.hibernate.Session;

import project2.models.User;
import project2.utils.HibernateUtil;

public class UserDao {
	public User save(User user) {
		try(Session sess = HibernateUtil.sessionFactory.openSession()) {
			sess.save(user);
			return user;
		}
	}
}
