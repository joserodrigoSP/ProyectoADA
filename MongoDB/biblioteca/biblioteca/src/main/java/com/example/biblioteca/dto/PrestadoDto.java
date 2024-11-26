package com.example.biblioteca.dto;

import jakarta.persistence.Column;

import java.util.Date;

public class PrestadoDto {
    private String id;
    private String titulo;
    private String autor;

    private String usuario;

    public PrestadoDto(String id, String titulo, String autor, Date fecha, String usuario) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.usuario = usuario;
    }

    public PrestadoDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
