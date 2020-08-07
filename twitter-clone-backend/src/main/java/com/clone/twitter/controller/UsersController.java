package com.clone.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.twitter.entity.UsersEntity;
import com.clone.twitter.service.UsersService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/v1")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsersController {

	
	@Autowired
	UsersService usersService;
	
	@RequestMapping("/fetchAllUsers")
	public List<UsersEntity> findAllUsers() {
		return usersService.findAllUsers();
	}
	
	
}
