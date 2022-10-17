package com.tunahan.libraryservice.exception;

public class LibraryNotFoundException extends RuntimeException {

	public LibraryNotFoundException(String message) {
		System.out.println(message);
	}
}
