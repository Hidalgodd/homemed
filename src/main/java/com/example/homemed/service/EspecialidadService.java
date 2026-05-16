package com.example.homemed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.homemed.dto.EspecialidadDTO;
import com.example.homemed.model.Especialidad;
import com.example.homemed.repository.EspecialidadRepository;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> obtenerTodas() {
        return especialidadRepository.findAll();
    }

    public List<EspecialidadDTO> obtenerTodasDTO() {
        return especialidadRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public Especialidad guardar(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    public EspecialidadDTO guardarDTO(Especialidad especialidad) {
        Especialidad nuevaEspecialidad = especialidadRepository.save(especialidad);
        return convertirADTO(nuevaEspecialidad);
    }

    public Especialidad obtenerPorId(Long id) {
        return especialidadRepository.findById(id).orElse(null);
    }

    public EspecialidadDTO obtenerPorIdDTO(Long id) {
        Especialidad especialidad = especialidadRepository.findById(id).orElse(null);

        if (especialidad == null) {
            return null;
        }

        return convertirADTO(especialidad);
    }

    public void eliminar(Long id) {
        especialidadRepository.deleteById(id);
    }

    private EspecialidadDTO convertirADTO(Especialidad especialidad) {
        return new EspecialidadDTO(
                especialidad.getId(),
                especialidad.getNombre()
        );
    }
}