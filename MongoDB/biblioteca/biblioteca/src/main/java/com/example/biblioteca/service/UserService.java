package com.example.biblioteca.service;

import com.example.biblioteca.document.UserDocument;
import com.example.biblioteca.dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto save(UserDto user);

    public List<UserDto> findAll();

    public UserDto findById(String id);

    public UserDto toDto(UserDocument user);

    public UserDocument toEntity(UserDto user);

    public void delete(String id);
    public UserDto update(String id, UserDto userDto);

    public void prestarlibro(String id, String idUsuario);

    public void devolverLibro(String idPrestamo, String idLibro, String idUsuario);
}
