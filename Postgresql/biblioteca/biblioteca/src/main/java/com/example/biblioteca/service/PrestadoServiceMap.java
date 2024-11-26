package com.example.biblioteca.service;

import com.example.biblioteca.dto.LibroDto;
import com.example.biblioteca.dto.PrestadoDto;
import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.entity.LibroEntity;
import com.example.biblioteca.entity.PrestadoEntity;
import com.example.biblioteca.entity.UserEntity;
import com.example.biblioteca.repository.LibroRepository;
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
    public PrestadoDto save(LibroEntity libro, String usuario) {
        PrestadoEntity libroEntiy = this.toPrestado(libro);
        libroEntiy.setFecha(new Date());
        libroEntiy.setUsuario(usuario);

        PrestadoEntity saveEntity = this.prestadoRepository.save(libroEntiy);

        return this.toDto(saveEntity);
    }

    @Override
    public PrestadoEntity toPrestado(LibroEntity libro) {

        PrestadoEntity prestadoDto = new PrestadoEntity();
        prestadoDto.setAutor(libro.getAutor());
        prestadoDto.setTitulo(libro.getTitulo());

        return prestadoDto;
    }

    @Override
    public List<PrestadoDto> findAll() {
        return this.prestadoRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());

    }

    @Override
    public PrestadoDto findById(Long id) {
        PrestadoEntity libro = this.prestadoRepository.findById(id).orElseThrow(null);

        return this.toDto(libro);
    }


    @Override
    public PrestadoDto toDto(PrestadoEntity prestado) {
        PrestadoDto dto = new PrestadoDto();
        dto.setId(prestado.getId());
        dto.setTitulo(prestado.getTitulo());
        dto.setAutor(prestado.getAutor());
        dto.setUsuario(prestado.getUsuario());

        return  dto;
    }

    @Override
    public PrestadoEntity toEntity(PrestadoDto prestado) {
        PrestadoEntity entity = new PrestadoEntity();
        entity.setTitulo(prestado.getTitulo());
        entity.setAutor(prestado.getAutor());
        entity.setUsuario(prestado.getUsuario());

        return  entity;
    }


    @Override
    public PrestadoDto update(Long id, PrestadoDto prestadoDto){
        PrestadoEntity prestadoEntity = this.prestadoRepository.findById(id).orElseThrow(null);

        prestadoEntity.setAutor(prestadoDto.getAutor());
        prestadoEntity.setTitulo(prestadoDto.getTitulo());
        prestadoEntity.setUsuario(prestadoDto.getUsuario());
        PrestadoEntity saveDto = this.prestadoRepository.save(prestadoEntity);

        return this.toDto(saveDto);
    }
    @Override
    public void delete(Long id){
       prestadoRepository.deleteById(id);
    }


}
