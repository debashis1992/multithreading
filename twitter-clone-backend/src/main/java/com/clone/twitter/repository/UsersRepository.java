package com.clone.twitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.twitter.entity.UsersEntity;

@Repository
public interface UsersRepository extends MongoRepository<UsersEntity, String>{

	
	
}
