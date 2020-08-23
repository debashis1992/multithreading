package com.clone.twitter.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public class BaseEntity {
	@CreatedBy
	public String crtUser;
	@CreatedDate
	public Instant crtDate;
	@LastModifiedBy
	public String lastUpdUsr;
	@LastModifiedDate
	public Instant lastUpdDt;

}
