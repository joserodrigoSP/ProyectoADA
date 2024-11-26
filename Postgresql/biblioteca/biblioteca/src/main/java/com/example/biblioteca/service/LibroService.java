package com.example.biblioteca.service;

import com.example.biblioteca.dto.LibroDto;
import com.example.biblioteca.dto.PrestadoDto;
import com.example.biblioteca.entity.LibroEntity;
import com.example.biblioteca.entity.PrestadoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibroService {

    public LibroDto save(LibroDto libro);

    public List<LibroDto> findAll();

    public LibroDto findById(Long id);

    public LibroDto toDto(LibroEntity libro);

    public LibroEntity toEntity(LibroDto libro);
    public LibroDto update(Long id, LibroDto libroDto);
    public void delete(Long id);
}
