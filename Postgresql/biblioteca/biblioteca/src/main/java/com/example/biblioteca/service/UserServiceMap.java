package com.example.biblioteca.service;

import com.example.biblioteca.dto.PrestadoDto;
import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.entity.LibroEntity;
import com.example.biblioteca.entity.PrestadoEntity;
import com.example.biblioteca.entity.UserEntity;
import com.example.biblioteca.exception.BibliotecaNotFoundException;
import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.repository.PrestadoRepository;
import com.example.biblioteca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceMap implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private PrestadoService prestadoService;
    @Override
    public UserDto save(UserDto user) {
        UserEntity userEntity = this.toEntity(user);
        UserEntity saveEntity = this.userRepository.save(userEntity);

        return this.toDto(saveEntity);
    }

    @Override
    public List<UserDto> findAll() {
        return this.userRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());

    }

    @Override
    public UserDto findById(Long id) {
        UserEntity user = this.userRepository.findById(id).orElseThrow(null);

        return this.toDto(user);
    }

    @Override
    public UserDto toDto(UserEntity user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setNombre(user.getNombre());
        dto.setLibroPrestado(user.getLibroPrestado());
        dto.setTituloLibro(user.getTituloLibro());
        return  dto;
    }

    @Override
    public UserEntity toEntity(UserDto user) {
        UserEntity entity = new UserEntity();
        entity.setNombre(user.getNombre());
        entity.setLibroPrestado(user.getLibroPrestado());
        entity.setTituloLibro(user.getTituloLibro());
        return  entity;
    }


    @Override
    public UserDto update(Long id, UserDto userDto){
        UserEntity userEntity = this.userRepository.findById(id).orElseThrow(()-> new BibliotecaNotFoundException("No se puede actualizar, no existe el usuario"));

        userEntity.setNombre(userDto.getNombre());

        UserEntity saveDto = this.userRepository.save(userEntity);

        return this.toDto(saveDto);
    }
    @Override
    public void delete(Long id){
        userRepository.deleteById(id);
    }
    @Override
    public void prestarlibro(Long id, Long idUsuario){
        LibroEntity libro = libroRepository.findById(id).orElseThrow(()-> new BibliotecaNotFoundException(" no existe el libro ID incorrecto"));
        libro.setLibroPrestado(true);
        libroRepository.save(libro);


        UserEntity userEntity = this.userRepository.findById(id).orElseThrow(()-> new BibliotecaNotFoundException("No se puede actualizar, no existe el usuario"));
        userEntity.setTituloLibro(libro.getTitulo());
        userEntity.setLibroPrestado(true);
        this.userRepository.save(userEntity);

        PrestadoDto saveDto = this.prestadoService.save(libro, userEntity.getNombre());

    }

    @Override
    public void devolverLibro(Long idPrestamo, Long idLibro, Long idUsuario){

        LibroEntity libro = libroRepository.findById(idLibro).orElseThrow(()-> new BibliotecaNotFoundException(" no existe el libro ID incorrecto"));
        libro.setLibroPrestado(false);
        libroRepository.save(libro);

        UserEntity userEntity = this.userRepository.findById(idUsuario).orElseThrow(()-> new BibliotecaNotFoundException("No se puede actualizar, no existe el usuario"));
        userEntity.setTituloLibro("");
        userEntity.setLibroPrestado(false);
        this.userRepository.save(userEntity);

        prestadoService.delete(idPrestamo);
    }

}
