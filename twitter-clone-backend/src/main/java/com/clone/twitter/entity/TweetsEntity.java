package com.clone.twitter.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.clone.twitter.domain.Comments;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Document("tweets")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TweetsEntity extends BaseEntity {
	
	@Id
	String id;
	String user;
	String tweet;
	Integer likes;
	List<Comments> comments;
	

}
