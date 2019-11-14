package project2.services;

import org.springframework.stereotype.Service;

import project2.daos.UserDao;
import project2.models.Credentials;
import project2.models.User;

@Service
public class UserService {
	UserDao userdao = new UserDao();

	public User createUser(Credentials cred) {
		System.out.println("Saving a User");
		return userdao.save(cred);
	}
}
