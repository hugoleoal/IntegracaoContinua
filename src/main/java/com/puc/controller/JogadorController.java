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
import com.puc.repository.JogadorRepository;
import com.puc.repository.TimeRepository;

@RestController
public class JogadorController {
	
	@Autowired
	private JogadorRepository repository;
	
	@RequestMapping(value = "/jogador", method = RequestMethod.POST)
	public Jogador salvarJogador(@RequestBody Jogador jogador) {
		return repository.save(jogador);
	}
	
	@RequestMapping(value = "/jogador", method = RequestMethod.GET)
	public List<Jogador> listarJogador() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/jogador", method = RequestMethod.PUT)
	public Jogador editarTime(@RequestBody Jogador jogador) {
		return repository.save(jogador);
	}

	 @RequestMapping(value = "/jogador/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	    {
	        Optional<Jogador> jogador = repository.findById(id);
	        if(jogador.isPresent()){
	            repository.delete(jogador.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}
