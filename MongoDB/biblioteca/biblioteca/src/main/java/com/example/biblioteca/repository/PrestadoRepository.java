package com.example.biblioteca.repository;

import com.example.biblioteca.document.PrestadoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestadoRepository extends MongoRepository<PrestadoDocument, String> {
}
