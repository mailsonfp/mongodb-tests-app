package com.mongodb.domain.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Post {

	@Id
	private String id;
	
	private String codigo;
	
	private String title;

	private String content;

	private LocalDateTime creationDate;
}
