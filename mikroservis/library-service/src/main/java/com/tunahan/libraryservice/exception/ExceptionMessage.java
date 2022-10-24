package com.tunahan.libraryservice.exception;

/*
 * Record
 * JVM de bir final class oluşturur
 * İçerisinde constructor ve get metodları bulunur
 * immutablity sağlar
 */
public record ExceptionMessage(
		String timestamp, 
		int status, 
		String error,
		String message, 
		String path) {
	
}



