package project2.services;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import project2.models.User;

@Service
public class UserService {

	public User createUser(@Valid User user) {
		System.out.println("Test1: Printing from the UserService class");
		return user;
	}
	
	

}
