package com.example.homemed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.homemed.dto.ReservaDTO;
import com.example.homemed.model.HoraMedica;
import com.example.homemed.model.Reserva;
import com.example.homemed.repository.HoraMedicaRepository;
import com.example.homemed.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HoraMedicaRepository horaMedicaRepository;

    public List<Reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }

    public List<ReservaDTO> obtenerTodasDTO() {
        return reservaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    public Reserva guardar(Reserva reserva) {
        Long idHora = reserva.getHoraMedica().getId();

        HoraMedica hora = horaMedicaRepository.findById(idHora).orElse(null);

        if (hora == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La hora médica no existe");
        }

        if (!Boolean.TRUE.equals(hora.getDisponible())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La hora médica no está disponible");
        }

        hora.setDisponible(false);
        horaMedicaRepository.save(hora);

        reserva.setHoraMedica(hora);

        return reservaRepository.save(reserva);
    }

    private ReservaDTO convertirADTO(Reserva reserva) {
        return new ReservaDTO(
                reserva.getId(),
                reserva.getUsuario().getNombre(),
                reserva.getHoraMedica().getMedico().getUsuario().getNombre(),
                reserva.getHoraMedica().getMedico().getEspecialidad().getNombre(),
                reserva.getHoraMedica().getFecha().toString(),
                reserva.getHoraMedica().getHora().toString(),
                reserva.getEstado(),
                reserva.getEstadoPago()
        );
    }

    public Reserva obtenerPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }
}