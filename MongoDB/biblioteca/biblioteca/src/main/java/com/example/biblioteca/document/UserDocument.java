package com.example.biblioteca.document;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserDocument {
    @Id
    private String id;
    private String nombre;
    private Boolean libroPrestado;
    private String tituloLibro;

    public UserDocument() {
    }

    public UserDocument(String id, String nombre, Boolean libroPrestado, String tituloLibro) {
        this.id = id;
        this.nombre = nombre;
        this.libroPrestado = libroPrestado;
        this.tituloLibro = tituloLibro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
