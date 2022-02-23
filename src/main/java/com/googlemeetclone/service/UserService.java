package com.googlemeetclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.googlemeetclone.model.User;
import com.googlemeetclone.repository.UserJpaRepository;

@Service
public class UserService {

	@Autowired
	private UserJpaRepository userJpaRepository;
	
	public String save(User user) {
		userJpaRepository.save(user);
		return "OK";
		
	}

	public User loginUser(User userParam) {
		User findByEmailEquals = userJpaRepository.findByEmailEquals(userParam.getEmail());
		if (findByEmailEquals.getPassword().equals(userParam.getPassword())) {
			return findByEmailEquals;
		}
		return null;
	}
}
