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

@Service
public class UserService {
	
	
	UserDao userDao = new UserDao();
	AttendantDao attendDao = new AttendantDao();
	
	@Autowired
	public UserService(UserDao userDao, AttendantDao attendDao) {
		super();
		this.userDao = userDao;
		this.attendDao = attendDao;
	}

	@Transactional
	public Users createUser(UserRegistration regreq) {
		return userDao.save(regreq);
	}
	
	@Transactional
	public Users getUserByCred(Credentials cred) {
		return userDao.getUserByCred(cred);
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
