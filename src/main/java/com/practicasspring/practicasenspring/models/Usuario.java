package com.practicasspring.practicasenspring.models;

import jakarta.persistence.Table;

@Table(name = "usuario")
public class Usuario {
    private long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String Password;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


}
