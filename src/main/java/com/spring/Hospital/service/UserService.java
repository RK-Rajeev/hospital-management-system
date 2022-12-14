package com.spring.Hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Hospital.entity.User;
import com.spring.Hospital.repository.UserRepository;

@Service("userService")
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void saveUser(User user) {
		userRepository.save(user);
	}

	public List<User> findAll() {

		return userRepository.findAll();
	}

}