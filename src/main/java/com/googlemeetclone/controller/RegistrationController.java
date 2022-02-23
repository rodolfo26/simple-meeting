package com.googlemeetclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.googlemeetclone.model.User;
import com.googlemeetclone.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public User register(@RequestBody User user) {
		userService.save(user);
		return user;
	}

}
