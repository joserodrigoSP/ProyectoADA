package com.example.biblioteca.service;

import com.example.biblioteca.document.LibroDocument;
import com.example.biblioteca.dto.LibroDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibroService {

    public LibroDto save(LibroDto libro);

    public List<LibroDto> findAll();

    public LibroDto findById(String id);

    public LibroDto toDto(LibroDocument libro);

    public LibroDocument toDocument(LibroDto libro);
    public LibroDto update(String id, LibroDto libroDto);
    public void delete(String id);
}
