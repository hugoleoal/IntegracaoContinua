package com.puc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puc.entity.TimeFutebol;

public interface TimeRepository extends JpaRepository<TimeFutebol, Long> {
	
}
