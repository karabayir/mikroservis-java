package com.tunahan.bookservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.bookservice.dto.BookDto;
import com.tunahan.bookservice.dto.BookDtoConverter;
import com.tunahan.bookservice.dto.BookIdDto;
import com.tunahan.bookservice.dto.BookIdDtoConverter;
import com.tunahan.bookservice.exception.BookNotFoundException;
import com.tunahan.bookservice.repository.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	private final BookDtoConverter bookDtoConverter;
	private final BookIdDtoConverter bookIdDtoConverter;

	public BookService(BookRepository bookRepository, 
			           BookDtoConverter bookDtoConverter,
			           BookIdDtoConverter bookIdDtoConverter) {
		
		this.bookRepository = bookRepository;
		this.bookDtoConverter = bookDtoConverter;
		this.bookIdDtoConverter = bookIdDtoConverter;
	}
	
	public List<BookDto> getAllBooks(){
		return bookRepository.findAll()
				.stream()
				.map(book->bookDtoConverter.convert(book))
				.collect(Collectors.toList());
	}
	
	public BookIdDto findByIsbn(String isbn) {
		return bookRepository.findBookByIsbn(isbn)
				.map(book->bookIdDtoConverter.convert(book))
				.orElseThrow(() -> new BookNotFoundException("Book could not found by isbn: "+isbn));
	}
	
	public BookDto findBookDetailsById(String id) {
		return bookRepository.findById(id)
				.map(book-> bookDtoConverter.convert(book))
				.orElseThrow(() -> new BookNotFoundException("Book could not found by id: "+ id));
	}

}
