package com.tunahan.libraryservice.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tunahan.libraryservice.dto.BookDto;
import com.tunahan.libraryservice.dto.BookIdDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@FeignClient(name = "book-service", path = "/v1/book")
public interface BookServiceClient {
	
	Logger logger = LoggerFactory.getLogger(BookServiceClient.class);
	
	@GetMapping("/isbn/{isbn}")
	@CircuitBreaker(name = "getBookByIsbnCircuitBreaker", fallbackMethod = "getBookFallback")
	 ResponseEntity<BookIdDto> findByIsbn(@PathVariable(value = "isbn") String isbn); //value="isbn" feign client için
	
	// Bu metod resilience4j ile ayrı bir thread ile çalıştırılacak.
	default ResponseEntity<BookIdDto> getBookFallback(String isbn, Exception exception){
		logger.info("Book not found by isbn "+isbn+" returning default  BootDto object" );
		
		return ResponseEntity.ok(new BookIdDto("default-book","default-isbn"));
	}
	
	
	@GetMapping("/book/{id}")
	@CircuitBreaker(name = "getBookByIdCircuitBreaker", fallbackMethod = "getBookByIdFallback")
	 ResponseEntity<BookDto> findBookDetailsById(@PathVariable(value = "id")  String id);
	
	// Bu metod resilience4j ile ayrı bir thread ile çalıştırılacak.
		default ResponseEntity<BookDto> getBookByIdFallback(String id, Exception exception){
			logger.info("Book not found by id "+id+" returning default  BootDto object" );
			
			return ResponseEntity.ok(new BookDto("default-book", "default-isbn"));
		}

}
