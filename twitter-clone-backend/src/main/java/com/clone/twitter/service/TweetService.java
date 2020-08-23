package com.clone.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clone.twitter.domain.TweetDomainRequest;
import com.clone.twitter.domain.TweetDomainResponse;
import com.clone.twitter.entity.TweetsEntity;
import com.clone.twitter.repository.TweetsRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TweetService {

	@Autowired
	private TweetsRepository tweetRepository;
	
	@Transactional
	public TweetDomainResponse saveTweet(TweetDomainRequest tweet) {
		TweetsEntity tweetEntity = TweetsEntity.builder().user(tweet.getUser())
						.tweet(tweet.getTweet()).likes(0).comments(null).build();
		TweetsEntity newTweetEntity = 
				tweetRepository.save(tweetEntity);
		log.info("New tweet saved : "+newTweetEntity.getId());
		TweetDomainResponse response = TweetDomainResponse.builder()
					.id(newTweetEntity.getId()).build();
		return response;
		
	}
}
