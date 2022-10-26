package com.tunahan.libraryservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tunahan.libraryservice.client.BookServiceClient;
import com.tunahan.libraryservice.dto.AddBookRequest;
import com.tunahan.libraryservice.dto.LibraryDto;
import com.tunahan.libraryservice.exception.LibraryNotFoundException;
import com.tunahan.libraryservice.model.Library;
import com.tunahan.libraryservice.repository.LibraryRepository;

@Service
public class LibraryService {

	private final LibraryRepository libraryRepository;
	private final BookServiceClient bookServiceClient;

	public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
		this.libraryRepository = libraryRepository;
		this.bookServiceClient = bookServiceClient;
	}
	
	public LibraryDto getAllBooksInLibraryById(String id) {
		
		Library library = libraryRepository.findById(id)
				.orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: "+id));
		
		LibraryDto libraryDto = new LibraryDto(
				
				library.getId(),
				
				library.getUserBookList()
				.stream()
				.map(book -> bookServiceClient.findBookDetailsById(book).getBody())
				.collect(Collectors.toList())
				);
		
		return libraryDto;
	}
	
	public LibraryDto createLibrary() {
		
		Library library = libraryRepository.save(new Library());
		
		return new LibraryDto(library.getId());
	}
	
	public void addBookToLibrary(AddBookRequest request) {
		
		String bookId = bookServiceClient.findByIsbn(request.getIsbn()).getBody().getId();
		
		Library library = libraryRepository.findById(request.getId())
				.orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: "+request.getId()));
		
		library.getUserBookList().add(bookId);
		
		libraryRepository.save(library);
	}

	public List<String> getAllLibraries() {
		return libraryRepository.findAll()
				.stream()
				.map(l-> l.getId())
				.collect(Collectors.toList());
	}
}
