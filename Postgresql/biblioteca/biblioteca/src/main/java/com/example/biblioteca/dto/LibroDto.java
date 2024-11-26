package com.example.biblioteca.dto;

import jakarta.persistence.Column;

public class LibroDto {

    private long id;
    private String titulo;
    private String autor;
    private Boolean libroPrestado;

    public LibroDto() {
    }

    public LibroDto(long id, String titulo, String autor, Boolean libroPrestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.libroPrestado = libroPrestado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Boolean getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Boolean libroPrestado) {
        this.libroPrestado = libroPrestado;
    }
}
