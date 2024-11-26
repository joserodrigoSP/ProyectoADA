package com.example.biblioteca.dto;

public class PrestamoRequest {

    private Long idLibro;
    private Long idUsuario;

    // Getters y setters
    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
