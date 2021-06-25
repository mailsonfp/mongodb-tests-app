package com.mongodb.api.mapper.dto.input;

import com.mongodb.domain.model.Author;

import lombok.Data;

@Data
public class CommentInputDto {
	
	private String commentPost;

	private Author author;
}
