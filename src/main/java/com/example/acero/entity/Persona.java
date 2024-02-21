package com.example.acero.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private String numerodocumento;
    private String email;
    private String password;
    private String telefono;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;



}
