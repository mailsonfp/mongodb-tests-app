package com.mongodb.domain.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Comment {
	
	@Id
	private String id;
	
	private String commentPost;

	private Author author;

	private LocalDateTime creationDate;
		
	private String postCode;

}
