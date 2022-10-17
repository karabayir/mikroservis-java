package com.tunahan.bookservice.controller;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.bookservice.dto.BookDto;
import com.tunahan.bookservice.dto.BookIdDto;
import com.tunahan.bookservice.service.BookService;

@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<BookDto>> getAllBooks(){
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	
	@GetMapping("/isbn/{isbn}")
	public ResponseEntity<BookIdDto> findByIsbn(@PathVariable @NotEmpty String isbn){
		return ResponseEntity.ok(bookService.findByIsbn(isbn));
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<BookDto> findBookDetailsById(@PathVariable @NotEmpty String id){
		return ResponseEntity.ok(bookService.findBookDetailsById(id));
	}
}
