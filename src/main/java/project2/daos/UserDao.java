package project2.daos;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project2.entities.Attendants;
import project2.entities.Users;
import project2.models.Credentials;
import project2.models.UserRegistration;
import project2.services.PasswordService;

@Component
public class UserDao {

    Date date = new Date();

    @Autowired
    PasswordService passServ;

    @PersistenceContext
    @Autowired(required = true)
    EntityManager em;

    /**
     * Saves a new user given new UserRegistration. Returns null if the password and confirmed password do not match
     * @param cred
     * @return
     */
    public Users save(UserRegistration regreq) {
        Session sess = em.unwrap(Session.class);
        Users user = newUser(regreq);
        byte[] salt = passServ.genSalt();
        byte[] hash = passServ.genHash(salt, regreq.getPassword());
        user.setPassword(hash);
        user.setSalt(salt);

        sess.persist(user);

        System.out.println("User Write Successful...");
        return user;
    }

    /**
     * Creates a new user given a UserRegistration object
     */
    private Users newUser(UserRegistration regreq) {
        Users user = new Users();
        user.setCreatedDate(new Timestamp(date.getTime()));
        user.setEmail(regreq.getEmail());
        user.setFirstname(regreq.getFirstName());
        user.setLastname(regreq.getLastName());
        user.setAvatarURL(regreq.getAvatar_url());
        return user;
    }

    /**
     * Validates credentials returning a found User from the database. Returns null if authentication fails.
     * @param cred
     * @return
     */
    public Users getUserByCred(Credentials cred) {
        Session sess = em.unwrap(Session.class);
        //Use Criteria here 
        CriteriaBuilder cb = sess.getCriteriaBuilder();
        CriteriaQuery<Users> cr = cb.createQuery(Users.class);
        Root<Users> root = cr.from(Users.class);
        cr.select(root).where(cb.like(root.get("email"), cred.getUsername()));

        Query<Users> query = sess.createQuery(cr);
        List<Users> results = query.getResultList();

        if (results.size() == 0) {
            System.out.println("User auth retrieved no users from DB...");
            return null;
        }

        Users user = results.get(0);
        byte[] hash = passServ.genHash(user.getSalt(), cred.getPassword());

        if (Arrays.equals(hash, user.getPassword())) {
            System.out.println("User Auth successful...");
            return user;
        } else {
            System.out.println("User was fetched, invalid password...");
            return null;
        }
    }

    public Users getUserById(int id) {
        Session sess = em.unwrap(Session.class);
        return sess.get(Users.class, id);
    }
    
    public List<Users> attendantsPerEvent(ArrayList<Integer> userId) {
      	String hql = "FROM Users WHERE user_id IN :userId";
		List<Users> myUsers = em.createQuery(hql, Users.class)
				.setParameter("userId", userId)
				.getResultList();
		return myUsers;
       
    }
    
    
}
