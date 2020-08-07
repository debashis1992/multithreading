package com.clone.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.twitter.entity.UsersEntity;
import com.clone.twitter.repository.UsersRepository;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsersService {
	
	@Autowired
	UsersRepository usersRepository;
	
	
	public List<UsersEntity> findAllUsers() {
		log.info("Fetching the list of users present...");
		return usersRepository.findAll();
	}

}
