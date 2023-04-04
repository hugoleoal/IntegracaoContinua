package com.puc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puc.entity.Torneio;

public interface TorneioRepository extends JpaRepository<Torneio, Long> {
	
}
