package com.example.biblioteca.service;

import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.entity.UserEntity;

import java.util.List;

public interface UserService {

    public UserDto save(UserDto user);

    public List<UserDto> findAll();

    public UserDto findById(Long id);

    public UserDto toDto(UserEntity user);

    public UserEntity toEntity(UserDto user);

    public void delete(Long id);
    public UserDto update(Long id, UserDto userDto);

    public void prestarlibro(Long id, Long idUsuario);

    public void devolverLibro(Long idPrestamo, Long idLibro, Long idUsuario);
}
