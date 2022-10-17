package com.tunahan.bookservice.dto;

import org.springframework.stereotype.Component;

import com.tunahan.bookservice.model.Book;

@Component
public class BookIdDtoConverter {

	public BookIdDto convert(Book book) {
		return new BookIdDto(
				book.getId(), 
				book.getIsbn()
				);
	}
}
