package com.tunahan.libraryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {
	
	
	@ExceptionHandler(LibraryNotFoundException.class)
	public ResponseEntity<?> handle(LibraryNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND );
	}

	
	/*@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<?> handle(BookNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND );
	}*/

	
	// Add BookNotFoundException with Exception
	
	/*
	 * Eclipse compile esnasında hata vermemektedir.
	 * Uygulama çalışıp BookNotFoundException yakalanırsa uygulama hata verecektir.
	 * Sevgili developer sen GeneralExceptionHandler içerisinde BookNotFound sınıfına ait hata
	 * durumlarını ayıklamak için (handle etmek için) 2 tane metod yazmışsın(handle,tunahan)
	 * Spring hangisini kullanacağına karar veremedi.Al sana yeni exception :)
	 * Bunun önüne geçebilmek için tek bir handle yapmamız gerekir(tunahan). 
	 */
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ExceptionMessage> handle(BookNotFoundException exception){
		return new ResponseEntity<>(exception.getExceptionMessage()
				,HttpStatus.resolve(exception.getExceptionMessage().status()));
	}
	
}
