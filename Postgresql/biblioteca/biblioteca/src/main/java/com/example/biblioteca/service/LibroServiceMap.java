package com.example.biblioteca.service;

import com.example.biblioteca.dto.LibroDto;
import com.example.biblioteca.dto.PrestadoDto;
import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.entity.LibroEntity;
import com.example.biblioteca.entity.PrestadoEntity;
import com.example.biblioteca.entity.UserEntity;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServiceMap implements LibroService {

    @Autowired
    LibroRepository libroRepository;


    @Override
    public LibroDto save(LibroDto libro) {
        LibroEntity libroEntiy = this.toEntity(libro);
        LibroEntity saveEntity = this.libroRepository.save(libroEntiy);

        return this.toDto(saveEntity);
    }

    @Override
    public List<LibroDto> findAll() {
        return this.libroRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());

    }

    @Override
    public LibroDto findById(Long id) {
        LibroEntity libro = this.libroRepository.findById(id).orElseThrow(null);

        return this.toDto(libro);
    }

    @Override
    public LibroDto toDto(LibroEntity libro) {
        LibroDto dto = new LibroDto();
        dto.setId(libro.getId());
        dto.setTitulo(libro.getTitulo());
        dto.setLibroPrestado(libro.getLibroPrestado());
        dto.setAutor(libro.getAutor());

        return  dto;
    }

    @Override
    public LibroEntity toEntity(LibroDto libro) {
        LibroEntity entity = new LibroEntity();
        entity.setTitulo(libro.getTitulo());
        entity.setLibroPrestado(libro.getLibroPrestado());
        entity.setAutor(libro.getAutor());
        return  entity;
    }



    @Override
    public LibroDto update(Long id, LibroDto libroDto){
        LibroEntity libroEntity = this.libroRepository.findById(id).orElseThrow(null);

        libroEntity.setAutor(libroDto.getAutor());
        libroEntity.setTitulo(libroDto.getTitulo());
        libroEntity.setLibroPrestado(libroDto.getLibroPrestado());
        LibroEntity saveDto = this.libroRepository.save(libroEntity);

        return this.toDto(saveDto);
    }
    @Override
    public void delete(Long id){
        libroRepository.deleteById(id);
    }


}
