package project2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2.daos.UserDao;
import project2.entities.Users;
import project2.models.Credentials;
import project2.models.UserRegistration;

@Service
public class UserService {
	UserDao userDao = new UserDao();
	
	@Autowired
	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Transactional
	public Users createUser(UserRegistration regreq) {
		return userDao.save(regreq);
	}
	
	@Transactional
	public Users getUserByCred(Credentials cred) {
		return userDao.getUserByCred(cred);
	}
}
