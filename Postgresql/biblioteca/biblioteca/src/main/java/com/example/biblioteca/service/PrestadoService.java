package com.example.biblioteca.service;

import com.example.biblioteca.dto.PrestadoDto;

import com.example.biblioteca.entity.LibroEntity;
import com.example.biblioteca.entity.PrestadoEntity;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PrestadoService {
    public PrestadoDto save(LibroEntity prestado, String usuario);

    public List<PrestadoDto> findAll();

    public PrestadoDto findById(Long id);

    public PrestadoDto toDto(PrestadoEntity prestado);
    public PrestadoEntity toPrestado(LibroEntity libro);
    public PrestadoEntity toEntity(PrestadoDto prestado);
    public PrestadoDto update(Long id, PrestadoDto prestadoDto);
    public void delete(Long id);
}
