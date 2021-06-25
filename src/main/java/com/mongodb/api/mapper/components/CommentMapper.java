package com.mongodb.api.mapper.components;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.api.mapper.dto.input.CommentInputDto;
import com.mongodb.api.mapper.dto.output.CommentOutputDto;
import com.mongodb.domain.model.Comment;

@Component
public class CommentMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public Comment toDomainObject(CommentInputDto postInput) {
		 return mapper.map(postInput, Comment.class);
	}
   
	public void copyToDomainObject(CommentInputDto commentModel, Comment comment) {		        
		 mapper.map(commentModel, comment);
	}
	 
	public CommentOutputDto toModel(Comment comment) {
		return mapper.map(comment, CommentOutputDto.class);
	}
	
	public List<CommentOutputDto> toCollectionModel(List<Comment> comments){
		return comments.stream()
				.map(comment -> toModel(comment))
				.collect(Collectors.toList());
	}
	
}
