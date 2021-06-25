package com.mongodb.api.mapper.dto.output;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostOutputDto {
	
	private String codigo;
	
	private String title;
	
	private String content;
	
	private LocalDateTime creationDate;
}
