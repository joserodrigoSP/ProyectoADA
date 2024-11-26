package com.example.biblioteca.dto;

import jakarta.persistence.Column;

public class UserDto {

    private long id;
    private String nombre;
    private Boolean libroPrestado;
    private String tituloLibro;

    public UserDto() {
    }

    public UserDto(long id, String nombre, Boolean libroPrestado, String tituloLibro) {
        this.id = id;
        this.nombre = nombre;
        this.libroPrestado = libroPrestado;
        this.tituloLibro = tituloLibro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Boolean libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }
}