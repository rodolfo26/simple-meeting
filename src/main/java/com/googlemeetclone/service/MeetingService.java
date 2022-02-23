package com.googlemeetclone.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlemeetclone.model.Meeting;
import com.googlemeetclone.repository.MeetingJpaRepository;

@Service
public class MeetingService {

	@Autowired
	private MeetingJpaRepository meetingJpaRepository;
	
	public Meeting save(Meeting meeting) {
		
		Meeting meetingInDB = meetingJpaRepository.findByMeetingIdAndUserName(meeting.getMeetingId(), meeting.getUserName());
		
		if (meetingInDB != null) {
			meeting = meetingInDB;
		} else {
			meeting.setStartDate(new Date());
		}
		meeting.setEndDate(null);
		meetingJpaRepository.save(meeting);
		
		return meeting;

	}
	
	public Meeting end(Meeting meeting) {
		
		Meeting meetingInDB = meetingJpaRepository.findByMeetingIdAndUserName(meeting.getMeetingId(), meeting.getUserName());
		
		if (meetingInDB != null) {
			meeting = meetingInDB;
		}
		meeting.setEndDate(new Date());
		meetingJpaRepository.save(meeting);
		
		return meeting;
		
	}
	
	public List<Meeting> participants(String meetingId) {
		
		List<Meeting> participants = meetingJpaRepository.findByMeetingId(meetingId);;
		return participants;
		
	}
}
