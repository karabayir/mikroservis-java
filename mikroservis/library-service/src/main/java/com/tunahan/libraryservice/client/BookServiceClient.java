package com.tunahan.libraryservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tunahan.libraryservice.dto.BookDto;
import com.tunahan.libraryservice.dto.BookIdDto;



@FeignClient(name = "book-service", path = "/v1/book")
public interface BookServiceClient {
	
	
	@GetMapping("/isbn/{isbn}")
	 ResponseEntity<BookIdDto> findByIsbn(@PathVariable String isbn);
	
	
	@GetMapping("/book/{id}")
	 ResponseEntity<BookDto> findBookDetailsById(@PathVariable  String id);
	

}
