package com.example.homemed.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "horas_medicas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoraMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hora_seq")
    @SequenceGenerator(name = "hora_seq", sequenceName = "hora_seq", allocationSize = 1)
    @Column(name = "id_hora")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "disponible")
    private Boolean disponible;
}