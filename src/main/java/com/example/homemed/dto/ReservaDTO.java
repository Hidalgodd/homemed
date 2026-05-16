package com.example.homemed.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {

    private Long id;
    private String paciente;
    private String medico;
    private String especialidad;
    private String fecha;
    private String hora;
    private String estado;
    private String estadoPago;
}