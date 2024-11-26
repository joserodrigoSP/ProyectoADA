package com.example.biblioteca.service;

import com.example.biblioteca.document.LibroDocument;
import com.example.biblioteca.document.PrestadoDocument;
import com.example.biblioteca.dto.PrestadoDto;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PrestadoService {
    public PrestadoDto save(LibroDocument prestado, String usuario);

    public List<PrestadoDto> findAll();

    public PrestadoDto findById(String id);

    public PrestadoDto toDto(PrestadoDocument prestado);
    public PrestadoDocument toPrestado(LibroDocument libro);
    public PrestadoDocument toEntity(PrestadoDto prestado);
    public PrestadoDto update(String id, PrestadoDto prestadoDto);
    public void delete(String id);
}
