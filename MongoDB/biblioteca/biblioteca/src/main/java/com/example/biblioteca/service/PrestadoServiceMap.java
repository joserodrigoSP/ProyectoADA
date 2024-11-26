package com.example.biblioteca.service;

import com.example.biblioteca.document.LibroDocument;
import com.example.biblioteca.document.PrestadoDocument;
import com.example.biblioteca.dto.PrestadoDto;
import com.example.biblioteca.repository.PrestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestadoServiceMap implements PrestadoService{

    @Autowired
    PrestadoRepository prestadoRepository;


    @Override
    public PrestadoDto save(LibroDocument libro, String usuario) {
        PrestadoDocument libroEntiy = this.toPrestado(libro);
        libroEntiy.setFecha(new Date());
        libroEntiy.setUsuario(usuario);

        PrestadoDocument saveEntity = this.prestadoRepository.save(libroEntiy);

        return this.toDto(saveEntity);
    }

    @Override
    public PrestadoDocument toPrestado(LibroDocument libro) {

        PrestadoDocument prestadoDto = new PrestadoDocument();
        prestadoDto.setAutor(libro.getAutor());
        prestadoDto.setTitulo(libro.getTitulo());

        return prestadoDto;
    }

    @Override
    public List<PrestadoDto> findAll() {
        return this.prestadoRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());

    }

    @Override
    public PrestadoDto findById(String id) {
        PrestadoDocument libro = this.prestadoRepository.findById(id).orElseThrow(null);

        return this.toDto(libro);
    }


    @Override
    public PrestadoDto toDto(PrestadoDocument prestado) {
        PrestadoDto dto = new PrestadoDto();
        dto.setId(prestado.getId());
        dto.setTitulo(prestado.getTitulo());
        dto.setAutor(prestado.getAutor());
        dto.setUsuario(prestado.getUsuario());

        return  dto;
    }

    @Override
    public PrestadoDocument toEntity(PrestadoDto prestado) {
        PrestadoDocument entity = new PrestadoDocument();
        entity.setTitulo(prestado.getTitulo());
        entity.setAutor(prestado.getAutor());
        entity.setUsuario(prestado.getUsuario());

        return  entity;
    }


    @Override
    public PrestadoDto update(String id, PrestadoDto prestadoDto){
        PrestadoDocument prestadoEntity = this.prestadoRepository.findById(id).orElseThrow(null);

        prestadoEntity.setAutor(prestadoDto.getAutor());
        prestadoEntity.setTitulo(prestadoDto.getTitulo());
        prestadoEntity.setUsuario(prestadoDto.getUsuario());
        PrestadoDocument saveDto = this.prestadoRepository.save(prestadoEntity);

        return this.toDto(saveDto);
    }
    @Override
    public void delete(String id){
       prestadoRepository.deleteById(id);
    }


}
