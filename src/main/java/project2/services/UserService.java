package project2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import project2.models.UserRegistration;
import project2.models.Users;
import project2.repositories.UserRepository;

@Service
public class UserService {
	UserRepository userRepo = new UserRepository();
	
	@Autowired
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Transactional
	public Users createUser(UserRegistration cred) {
		return userRepo.save(cred);
	}
}
