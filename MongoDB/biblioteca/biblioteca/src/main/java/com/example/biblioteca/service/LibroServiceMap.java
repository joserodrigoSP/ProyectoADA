package com.example.biblioteca.service;

import com.example.biblioteca.document.LibroDocument;
import com.example.biblioteca.dto.LibroDto;
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
        LibroDocument libroDocument = this.toDocument(libro);
        LibroDocument saveDocument = this.libroRepository.save(libroDocument);

        return this.toDto(saveDocument);
    }

    @Override
    public List<LibroDto> findAll() {
        return this.libroRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());

    }

    @Override
    public LibroDto findById(String id) {
        LibroDocument libro = this.libroRepository.findById(id).orElseThrow(null);

        return this.toDto(libro);
    }

    @Override
    public LibroDto toDto(LibroDocument libro) {
        LibroDto dto = new LibroDto();
        dto.setId(libro.getId());
        dto.setTitulo(libro.getTitulo());
        dto.setLibroPrestado(libro.getLibroPrestado());
        dto.setAutor(libro.getAutor());

        return  dto;
    }

    @Override
    public LibroDocument toDocument(LibroDto libro) {
        LibroDocument document = new LibroDocument();
        document.setTitulo(libro.getTitulo());
        document.setLibroPrestado(libro.getLibroPrestado());
        document.setAutor(libro.getAutor());
        return  document;
    }



    @Override
    public LibroDto update(String id, LibroDto libroDto){
        LibroDocument libroDocument = this.libroRepository.findById(id).orElseThrow(null);

        libroDocument.setAutor(libroDto.getAutor());
        libroDocument.setTitulo(libroDto.getTitulo());
        libroDocument.setLibroPrestado(libroDto.getLibroPrestado());
        LibroDocument saveDto = this.libroRepository.save(libroDocument);

        return this.toDto(saveDto);
    }
    @Override
    public void delete(String id){
        libroRepository.deleteById(id);
    }


}
