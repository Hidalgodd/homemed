package com.example.homemed.controller;

import com.example.homemed.dto.HoraMedicaDTO;
import com.example.homemed.model.HoraMedica;
import com.example.homemed.service.HoraMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horas")
public class HoraMedicaController {

    @Autowired
    private HoraMedicaService horaMedicaService;

    @GetMapping
    public ResponseEntity<List<HoraMedica>> listar() {
        return ResponseEntity.ok(horaMedicaService.obtenerTodas());
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<HoraMedicaDTO>> listarDisponibles() {
        return ResponseEntity.ok(horaMedicaService.obtenerDisponiblesDTO());
    }

    @PostMapping
    public ResponseEntity<HoraMedica> guardar(@RequestBody HoraMedica horaMedica) {
        HoraMedica nuevaHora = horaMedicaService.guardar(horaMedica);
        return ResponseEntity.status(201).body(nuevaHora);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoraMedica> obtener(@PathVariable Long id) {
        HoraMedica hora = horaMedicaService.obtenerPorId(id);

        if (hora == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(hora);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        HoraMedica hora = horaMedicaService.obtenerPorId(id);

        if (hora == null) {
            return ResponseEntity.notFound().build();
        }

        horaMedicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}