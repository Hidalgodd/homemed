package com.example.homemed.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nombre_seq")
    @SequenceGenerator(name = "nombre_seq", sequenceName = "nombre_seq", allocationSize = 1)
    @Column(name = "id_reserva")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_hora", nullable = false)
    private HoraMedica horaMedica;

    @Column(name = "estado")
    private String estado;

    @Column(name = "estado_pago")
    private String estadoPago;
}