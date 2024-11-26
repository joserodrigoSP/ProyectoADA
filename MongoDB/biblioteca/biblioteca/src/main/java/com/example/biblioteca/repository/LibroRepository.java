package com.example.biblioteca.repository;

import com.example.biblioteca.document.LibroDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends MongoRepository<LibroDocument, String> {
}
