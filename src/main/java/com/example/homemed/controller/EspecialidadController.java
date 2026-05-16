package com.example.homemed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.homemed.dto.EspecialidadDTO;
import com.example.homemed.model.Especialidad;
import com.example.homemed.service.EspecialidadService;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public ResponseEntity<List<EspecialidadDTO>> listar() {
        return ResponseEntity.ok(especialidadService.obtenerTodasDTO());
    }

    @PostMapping
    public ResponseEntity<EspecialidadDTO> guardar(@RequestBody Especialidad especialidad) {
        EspecialidadDTO nuevaEspecialidad = especialidadService.guardarDTO(especialidad);
        return ResponseEntity.status(201).body(nuevaEspecialidad);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> obtener(@PathVariable Long id) {
        EspecialidadDTO especialidad = especialidadService.obtenerPorIdDTO(id);

        if (especialidad == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(especialidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Especialidad especialidad = especialidadService.obtenerPorId(id);

        if (especialidad == null) {
            return ResponseEntity.notFound().build();
        }

        especialidadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}