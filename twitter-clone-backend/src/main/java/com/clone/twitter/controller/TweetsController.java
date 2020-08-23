package com.clone.twitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clone.twitter.domain.TweetDomainRequest;
import com.clone.twitter.domain.TweetDomainResponse;
import com.clone.twitter.service.TweetService;

@RestController
@RequestMapping("/api/v1/tweets")
public class TweetsController {
	
	@Autowired
	private TweetService tweetService;

	@PostMapping(value = "/", consumes = "application/json")
	@ResponseBody
	public TweetDomainResponse saveTweet(@RequestBody TweetDomainRequest tweetDomainObj) {
		return tweetService.saveTweet(tweetDomainObj);
	}
	
}
