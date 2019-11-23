package project2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2.daos.AttendantDao;
import project2.daos.UserDao;
import project2.entities.Attendants;
import project2.entities.Users;
import project2.models.Credentials;
import project2.models.UserRegistration;
import project2.models.UserResponse;

@Service
public class UserService {
	
	
	UserDao userDao = new UserDao();
	AttendantDao attendDao = new AttendantDao();
	JWTService jwtServ = new JWTService();
	
	@Autowired
	public UserService(UserDao userDao, AttendantDao attendDao, JWTService jwtServ) {
		super();
		this.userDao = userDao;
		this.attendDao = attendDao;
		this.jwtServ = jwtServ;
	}

	@Transactional
	public UserResponse createUser(UserRegistration regreq){
		Users user = userDao.save(regreq);
		UserResponse uresp = new UserResponse(user);
		uresp.setJwt(jwtServ.signJWT(user));
		return uresp;
	}
	
	@Transactional
	public Users getUserByCred(Credentials cred) {
		try {
			return userDao.getUserByCred(cred);
		} catch (NullPointerException e) {
			System.out.println("Unable to Authenicate Credentials: NullPointerException");
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public Users getUserById(int id) {
		return userDao.getUserById(id);
	}
	@Transactional
	public List<Users> findNumberOfAttendants(int eventId) {
		System.out.println("This is the event ID from Client " + eventId);
		List<Attendants> listOfAttendants = attendDao.returnUserPerEventId(eventId);
		ArrayList<Integer> mylist = new ArrayList<Integer>();
		  for(Attendants i: listOfAttendants) {
			 mylist.add(i.getUser_id());
		}
		 return userDao.attendantsPerEvent(mylist);
	}
}
