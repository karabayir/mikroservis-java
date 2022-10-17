package com.tunahan.bookservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.bookservice.dto.BookIdDto;
import com.tunahan.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {

	Optional<Book> findBookByIsbn(String isbn);

}
