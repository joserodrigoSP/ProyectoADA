package com.example.biblioteca.document;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "libros")
public class LibroDocument {

    @Id
    private String id;
    private String titulo;
    private String autor;
    private Boolean libroPrestado;

    public LibroDocument() {
    }

    public LibroDocument(String id, String titulo, String autor, Boolean libroPrestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.libroPrestado = libroPrestado;
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

    public Boolean getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Boolean libroPrestado) {
        this.libroPrestado = libroPrestado;
    }
}
