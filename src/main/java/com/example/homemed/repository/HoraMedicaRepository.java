package com.example.homemed.repository;

import com.example.homemed.model.HoraMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HoraMedicaRepository extends JpaRepository<HoraMedica, Long> {

    List<HoraMedica> findByDisponibleTrue();

}