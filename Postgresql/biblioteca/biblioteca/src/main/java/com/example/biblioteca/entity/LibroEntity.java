package com.example.biblioteca.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class LibroEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "autor", nullable = false)
    private String autor;
    @Column(name = "prestado", nullable = false)
    private Boolean libroPrestado;




    public LibroEntity() {

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
