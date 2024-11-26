package com.example.biblioteca.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "prestados")
public class PrestadoEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "autor", nullable = false)
    private String autor;
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Column(name = "usuario", nullable = false)
    private String usuario;

    public PrestadoEntity() {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
