package com.mongodb.domain.model;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Comment {

	private String id;

	private String comment;

	private String author;

	private LocalDateTime creationDate;
	
	private Post post;

}
