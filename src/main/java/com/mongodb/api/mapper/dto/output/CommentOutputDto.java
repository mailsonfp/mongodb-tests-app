package com.mongodb.api.mapper.dto.output;

import java.time.LocalDateTime;

import com.mongodb.domain.model.Author;

import lombok.Data;

@Data
public class CommentOutputDto {
	
	private String commentPost;

	private Author author;

	private LocalDateTime creationDate;
}
