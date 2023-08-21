package com.practicasspring.practicasenspring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Getter @Setter
    private long id;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String apellido;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String telefono;
    @Getter @Setter
    private String Password;


}
