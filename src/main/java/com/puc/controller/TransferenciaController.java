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
import com.puc.entity.Transferencia;
import com.puc.repository.JogadorRepository;
import com.puc.repository.TimeRepository;
import com.puc.repository.TransferenciasRepository;

@RestController
public class TransferenciaController {
	
	@Autowired
	private TransferenciasRepository repository;
	
	@RequestMapping(value = "/transferencia", method = RequestMethod.POST)
	public Transferencia salvarJogador(@RequestBody Transferencia transferencia) {
		return repository.save(transferencia);
	}
	
	@RequestMapping(value = "/transferencia", method = RequestMethod.GET)
	public List<Transferencia> listarJogador() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/transferencia", method = RequestMethod.PUT)
	public Transferencia editarTime(@RequestBody Transferencia transferencia) {
		return repository.save(transferencia);
	}

	 @RequestMapping(value = "/transferencia/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	    {
	        Optional<Transferencia> jogador = repository.findById(id);
	        if(jogador.isPresent()){
	            repository.delete(jogador.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
}
