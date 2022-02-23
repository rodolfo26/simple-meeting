package com.googlemeetclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.googlemeetclone.model.Meeting;
import com.googlemeetclone.model.User;
import com.googlemeetclone.service.MeetingService;
import com.googlemeetclone.service.UserService;

@RestController
public class MeetingController {

	@Autowired
	private UserService userService;

	@Autowired
	private MeetingService meetingService;
	
	@RequestMapping("/start")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<Meeting> start(@RequestBody Meeting meetingParam) {
		Meeting meeting = meetingService.save(meetingParam);
		if (meeting == null) {
			return new ResponseEntity<Meeting>(HttpStatus.UNAUTHORIZED);
		} else {
			return ResponseEntity.ok(meeting);
		}
	}
	
	@RequestMapping("/end")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<Meeting> end(@RequestBody Meeting meetingParam) {
		Meeting meeting = meetingService.end(meetingParam);
		if (meeting == null) {
			return new ResponseEntity<Meeting>(HttpStatus.UNAUTHORIZED);
		} else {
			return ResponseEntity.ok(meeting);
		}
	}
	
	@RequestMapping("/participants")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public ResponseEntity<List<Meeting>> participants(@RequestBody Meeting meetingParam) {
		List<Meeting> meetings = meetingService.participants(meetingParam.getMeetingId());
		if (meetings == null) {
			return new ResponseEntity<List<Meeting>>(HttpStatus.UNAUTHORIZED);
		} else {
			return ResponseEntity.ok(meetings);
		}
	}
}
