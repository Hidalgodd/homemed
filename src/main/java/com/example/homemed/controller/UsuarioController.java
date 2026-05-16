package com.example.homemed.controller;

import com.example.homemed.dto.UsuarioDTO;
import com.example.homemed.model.Usuario;
import com.example.homemed.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(usuarioService.obtenerTodosDTO());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> guardar(@RequestBody Usuario usuario) {
        UsuarioDTO nuevoUsuario = usuarioService.guardarDTO(usuario);
        return ResponseEntity.status(201).body(nuevoUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtener(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.obtenerPorIdDTO(id);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerPorId(id);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}