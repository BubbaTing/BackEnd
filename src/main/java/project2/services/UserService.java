package project2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project2.daos.UserDao;
import project2.models.Credentials;
import project2.models.UserRegistration;
import project2.models.Users;

@Service
public class UserService {
	UserDao userRepo = new UserDao();
	
	@Autowired
	public UserService(UserDao userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Transactional
	public Users createUser(UserRegistration regreq) {
		return userRepo.save(regreq);
	}
	
	@Transactional
	public Users getUserByCred(Credentials cred) {
		return userRepo.getUserByCred(cred);
	}
}
