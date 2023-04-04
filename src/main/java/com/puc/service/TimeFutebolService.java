package com.puc.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.puc.entity.TimeFutebol;
import com.puc.repository.TimeRepository;

public class TimeFutebolService implements ApplicationRunner{

	private final TimeRepository repository;

	public TimeFutebolService(TimeRepository repository) {
		this.repository = repository;
	}
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		TimeFutebol timeFutebol = new TimeFutebol();
	timeFutebol.setName("Flamengo");
	timeFutebol.setLocalidade("Rio de Janeiro");
		repository.save(timeFutebol);
		
	}

}
