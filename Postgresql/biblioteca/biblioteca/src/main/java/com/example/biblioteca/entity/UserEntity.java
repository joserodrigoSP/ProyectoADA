package com.example.biblioteca.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class UserEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String nombre;
    @Column(name = "prestado", nullable = false)
    private Boolean libroPrestado;
    @Column(name = "titulo", nullable = false)
    private String tituloLibro;



    public UserEntity() {

        this.libroPrestado = false;
        this.tituloLibro = "NO TIENE";
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
