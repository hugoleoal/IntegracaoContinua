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

import com.puc.entity.Jogador;
import com.puc.entity.TimeFutebol;
import com.puc.entity.Torneio;
import com.puc.repository.JogadorRepository;
import com.puc.repository.TimeRepository;
import com.puc.repository.TorneioRepository;

@RestController
public class TorneioController {
	
	@Autowired
	private TorneioRepository repository;
	
	@RequestMapping(value = "/torneio", method = RequestMethod.POST)
	public Torneio salvarTorneio(@RequestBody Torneio torneio) {
		return repository.save(torneio);
	}
	
	@RequestMapping(value = "/torneio", method = RequestMethod.GET)
	public List<Torneio> listarTorneio() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/torneio", method = RequestMethod.PUT)
	public Torneio editarTorneio(@RequestBody Torneio torneio) {
		return repository.save(torneio);
	}

	 @RequestMapping(value = "/torneio/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	    {
	        Optional<Torneio> torneio = repository.findById(id);
	        if(torneio.isPresent()){
	            repository.delete(torneio.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}
