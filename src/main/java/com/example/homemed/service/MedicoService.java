package com.example.homemed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.homemed.dto.MedicoDTO;
import com.example.homemed.model.Medico;
import com.example.homemed.repository.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> obtenerTodos() {
        return medicoRepository.findAll();
    }

    public List<MedicoDTO> obtenerTodosDTO() {
        return medicoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public Medico guardar(Medico medico) {
        return medicoRepository.save(medico);
    }

    public MedicoDTO guardarDTO(Medico medico) {
        Medico nuevoMedico = medicoRepository.save(medico);
        return convertirADTO(nuevoMedico);
    }

    public Medico obtenerPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public MedicoDTO obtenerPorIdDTO(Long id) {
        Medico medico = medicoRepository.findById(id).orElse(null);

        if (medico == null) {
            return null;
        }

        return convertirADTO(medico);
    }

    public void eliminar(Long id) {
        medicoRepository.deleteById(id);
    }

    private MedicoDTO convertirADTO(Medico medico) {
        return new MedicoDTO(
                medico.getId(),
                medico.getUsuario().getNombre(),
                medico.getEspecialidad().getNombre()
        );
    }
}