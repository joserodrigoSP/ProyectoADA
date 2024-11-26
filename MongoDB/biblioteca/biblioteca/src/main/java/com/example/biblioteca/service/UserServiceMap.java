package com.example.biblioteca.service;

import com.example.biblioteca.document.LibroDocument;
import com.example.biblioteca.document.UserDocument;
import com.example.biblioteca.dto.PrestadoDto;
import com.example.biblioteca.dto.UserDto;
import com.example.biblioteca.exception.BibliotecaNotFoundException;
import com.example.biblioteca.repository.LibroRepository;
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
        UserDocument userEntity = this.toEntity(user);
        UserDocument saveEntity = this.userRepository.save(userEntity);

        return this.toDto(saveEntity);
    }

    @Override
    public List<UserDto> findAll() {
        return this.userRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());

    }

    @Override
    public UserDto findById(String id) {
        UserDocument user = this.userRepository.findById(id).orElseThrow(null);

        return this.toDto(user);
    }

    @Override
    public UserDto toDto(UserDocument user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setNombre(user.getNombre());
        dto.setLibroPrestado(user.getLibroPrestado());
        dto.setTituloLibro(user.getTituloLibro());
        return  dto;
    }

    @Override
    public UserDocument toEntity(UserDto user) {
        UserDocument entity = new UserDocument();
        entity.setNombre(user.getNombre());
        entity.setLibroPrestado(user.getLibroPrestado());
        entity.setTituloLibro(user.getTituloLibro());
        return  entity;
    }


    @Override
    public UserDto update(String id, UserDto userDto){
        UserDocument userEntity = this.userRepository.findById(id).orElseThrow(()-> new BibliotecaNotFoundException("No se puede actualizar, no existe el usuario"));

        userEntity.setNombre(userDto.getNombre());

        UserDocument saveDto = this.userRepository.save(userEntity);

        return this.toDto(saveDto);
    }
    @Override
    public void delete(String id){
        userRepository.deleteById(id);
    }


    @Override
    public void prestarlibro(String id, String idUsuario){
        LibroDocument libro = libroRepository.findById(id)
                .orElseThrow(() -> new BibliotecaNotFoundException("Libro no encontrado con ID: " + id));


        libro.setLibroPrestado(true);
        libroRepository.save(libro);

        UserDocument userEntity = userRepository.findById(idUsuario)
                .orElseThrow(() -> new BibliotecaNotFoundException("Usuario no encontrado con ID: " + idUsuario));

        userEntity.setTituloLibro(libro.getTitulo());
        userEntity.setLibroPrestado(true);
        userRepository.save(userEntity);

        prestadoService.save(libro, userEntity.getNombre());

    }

    @Override
    public void devolverLibro(String idPrestamo, String idLibro, String idUsuario){

        LibroDocument libro = libroRepository.findById(idLibro).orElseThrow(()-> new BibliotecaNotFoundException(" no existe el libro ID incorrecto"));
        libro.setLibroPrestado(false);
        libroRepository.save(libro);

        UserDocument userEntity = this.userRepository.findById(idUsuario).orElseThrow(()-> new BibliotecaNotFoundException("No se puede actualizar, no existe el usuario"));
        userEntity.setTituloLibro("");
        userEntity.setLibroPrestado(false);
        this.userRepository.save(userEntity);

        prestadoService.delete(idPrestamo);
    }

}
