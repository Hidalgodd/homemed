package com.example.homemed.service;

import com.example.homemed.dto.HoraMedicaDTO;
import com.example.homemed.model.HoraMedica;
import com.example.homemed.repository.HoraMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoraMedicaService {

    @Autowired
    private HoraMedicaRepository horaMedicaRepository;

    public List<HoraMedica> obtenerTodas() {
        return horaMedicaRepository.findAll();
    }

    public HoraMedica guardar(HoraMedica horaMedica) {
        return horaMedicaRepository.save(horaMedica);
    }

    public HoraMedica obtenerPorId(Long id) {
        return horaMedicaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        horaMedicaRepository.deleteById(id);
    }

    public List<HoraMedica> obtenerDisponibles() {
        return horaMedicaRepository.findByDisponibleTrue();
    }

    public List<HoraMedicaDTO> obtenerDisponiblesDTO() {
        return horaMedicaRepository.findByDisponibleTrue()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    private HoraMedicaDTO convertirADTO(HoraMedica hora) {
        return new HoraMedicaDTO(
                hora.getId(),
                hora.getMedico().getUsuario().getNombre(),
                hora.getMedico().getEspecialidad().getNombre(),
                hora.getFecha().toString(),
                hora.getHora().toString(),
                hora.getDisponible()
        );
    }
}