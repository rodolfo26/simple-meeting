package com.googlemeetclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.googlemeetclone.model.User;
import com.googlemeetclone.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<User> register(@RequestBody User user) {
		User loginUser = userService.loginUser(user);
		if (loginUser == null) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		} else {
			return ResponseEntity.ok(loginUser);
		}
	}
}
