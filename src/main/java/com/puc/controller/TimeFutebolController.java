package com.puc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.puc.entity.TimeFutebol;
import com.puc.repository.TimeRepository;

@RestController
public class TimeFutebolController {
	
	@Autowired
	private TimeRepository repository;
	
	@RequestMapping(value = "/time", method = RequestMethod.POST)
	public TimeFutebol salvarTime(@RequestBody TimeFutebol time) {
		return repository.save(time);
	}
	
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public List<TimeFutebol> listarTime() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/time", method = RequestMethod.PUT)
	public TimeFutebol editarTime(@RequestBody TimeFutebol time) {
		return repository.save(time);
	}

	 @RequestMapping(value = "/time/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	    {
	        Optional<TimeFutebol> time = repository.findById(id);
	        if(time.isPresent()){
	            repository.delete(time.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}
