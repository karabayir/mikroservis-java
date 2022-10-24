package com.tunahan.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
	
	
	private String id;
	private String title;
	private int bookYear;
	private String author;
	private String pressName;	
	private String isbn;
	
	public BookDto(String id, String isbn) {
		this.id=id;
		this.isbn=isbn;
	}


}
