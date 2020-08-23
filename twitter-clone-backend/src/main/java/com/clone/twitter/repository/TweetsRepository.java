package com.clone.twitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clone.twitter.entity.TweetsEntity;

@Repository
public interface TweetsRepository extends MongoRepository<TweetsEntity, String>{

}
