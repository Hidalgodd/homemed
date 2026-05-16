package com.example.homemed.controller;

import com.example.homemed.dto.MedicoDTO;
import com.example.homemed.model.Medico;
import com.example.homemed.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listar() {
        return ResponseEntity.ok(medicoService.obtenerTodosDTO());
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> guardar(@RequestBody Medico medico) {
        MedicoDTO nuevoMedico = medicoService.guardarDTO(medico);
        return ResponseEntity.status(201).body(nuevoMedico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> obtener(@PathVariable Long id) {
        MedicoDTO medico = medicoService.obtenerPorIdDTO(id);

        if (medico == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(medico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Medico medico = medicoService.obtenerPorId(id);

        if (medico == null) {
            return ResponseEntity.notFound().build();
        }

        medicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}