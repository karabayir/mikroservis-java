package com.tunahan.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookDto {
	
	
	private String id;
	private String title;
	private int bookYear;
	private String author;
	private String pressName;	
	private String isbn;


}
