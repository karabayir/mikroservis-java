package com.tunahan.libraryservice.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryDto {
	
	private String id;
	private List<BookDto> userBookList;
	
	public LibraryDto(String id) {
		this.id=id;	
		this.userBookList = new ArrayList();
	}
}
