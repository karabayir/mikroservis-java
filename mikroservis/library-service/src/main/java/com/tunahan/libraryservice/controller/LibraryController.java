package com.tunahan.libraryservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunahan.libraryservice.dto.AddBookRequest;
import com.tunahan.libraryservice.dto.LibraryDto;
import com.tunahan.libraryservice.service.LibraryService;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

	private final LibraryService libraryService;

	public LibraryController(LibraryService libraryService) {
		this.libraryService = libraryService;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id){
		return ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));
	}
	
	@PostMapping()
	public ResponseEntity<LibraryDto> createLibrary(){
		return ResponseEntity.ok(libraryService.createLibrary());
	}
	
	@PutMapping
	public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request){
		libraryService.addBookToLibrary(request);
		return ResponseEntity.ok().build();
	}
}
