package com.mongodb.api.mapper.dto.output;

import java.util.List;

import lombok.Data;

@Data
public class PostCommentOutputDto {
	
	private PostOutputDto post;
	
	List<CommentOutputDto> comments;
}
