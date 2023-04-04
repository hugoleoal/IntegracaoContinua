package com.puc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puc.entity.EventoPartida;

public interface EventoRepository extends JpaRepository<EventoPartida, Long> {

}
