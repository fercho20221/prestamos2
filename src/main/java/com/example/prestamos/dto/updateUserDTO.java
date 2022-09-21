package com.example.prestamos.dto;

public class updateUserDTO {

    public int Id;
    private String nombres;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    private String apellidos;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
