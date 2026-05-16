package com.example.homemed.controller;

import com.example.homemed.model.Especialidad;
import com.example.homemed.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public List<Especialidad> listar() {
        return especialidadService.obtenerTodas();
    }

    @PostMapping
    public Especialidad guardar(@RequestBody Especialidad especialidad) {
        return especialidadService.guardar(especialidad);
    }

    @GetMapping("/{id}")
    public Especialidad obtener(@PathVariable Long id) {
        return especialidadService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        especialidadService.eliminar(id);
    }
}