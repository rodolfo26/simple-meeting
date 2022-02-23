package com.googlemeetclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.googlemeetclone.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, String>{
	User findByEmailEquals(String email);
}
