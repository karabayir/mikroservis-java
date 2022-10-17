package com.tunahan.bookservice.dto;

import org.springframework.stereotype.Component;

import com.tunahan.bookservice.model.Book;

@Component
public class BookDtoConverter {
	
	public BookDto convert(Book book) {
		
		return new BookDto(
				book.getId(), 
				book.getTitle(), 
				book.getBookYear(), 
				book.getAuthor(), 
				book.getPressName(), 
				book.getIsbn());
	}

}
