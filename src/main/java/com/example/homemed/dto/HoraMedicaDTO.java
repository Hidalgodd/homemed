package com.example.homemed.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoraMedicaDTO {

    private Long id;
    private String medico;
    private String especialidad;
    private String fecha;
    private String hora;
    private Boolean disponible;
}