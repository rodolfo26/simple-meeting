package com.googlemeetclone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.googlemeetclone.model.Meeting;
import com.googlemeetclone.model.User;

@Repository
public interface MeetingJpaRepository extends JpaRepository<Meeting, Long>{
	Meeting findByMeetingIdAndUserName(String meetingId, String userName);

	List<Meeting> findByMeetingId(String meetingId);
}
