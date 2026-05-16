package com.example.homemed.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "especialidades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nombre_seq")
    @SequenceGenerator(name = "nombre_seq", sequenceName = "nombre_seq", allocationSize = 1)
    @Column(name = "id_especialidad")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;
}