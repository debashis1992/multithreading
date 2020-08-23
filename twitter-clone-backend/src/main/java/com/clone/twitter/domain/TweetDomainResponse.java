package com.clone.twitter.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TweetDomainResponse {
	String id;
	@Builder.Default
	String message = "New tweet saved successfully";
}
