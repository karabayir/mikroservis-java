package com.tunahan.libraryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.libraryservice.model.Library;

public interface LibraryRepository extends JpaRepository<Library, String>{

}
