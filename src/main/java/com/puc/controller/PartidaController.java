package com.puc.controller;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.h2.engine.CastDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.puc.entity.EventoPartida;
import com.puc.entity.Partida;
import com.puc.entity.Torneio;
import com.puc.repository.EventoRepository;
import com.puc.repository.PartidaRepository;
import com.puc.repository.TorneioRepository;

@RestController
public class PartidaController {
	
	@Autowired
	private PartidaRepository repository;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private TorneioRepository torneioRepository;
	
	@RequestMapping(value = "/partida", method = RequestMethod.POST)
	public Partida salvarPartida(@RequestBody Partida partida) {
		return repository.save(partida);
	}
	
	@RequestMapping(value = "/partida", method = RequestMethod.GET)
	public List<Partida> listarPartida() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/partida", method = RequestMethod.PUT)
	public Partida editarPartida(@RequestBody Partida partida) {
		return repository.save(partida);
	}

	 @RequestMapping(value = "/partida/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	    {
	        Optional<Partida> partida = repository.findById(id);
	        if(partida.isPresent()){
	            repository.delete(partida.get());
	            return new ResponseEntity<>(HttpStatus.OK);
	        }
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 
		@RequestMapping(value = "/torneios/{id}/partidas/{idp}/eventos/inicio", method = RequestMethod.POST)
		public ResponseEntity<Object> salvarEventoInicio(@PathVariable(value = "id") long id,
				@PathVariable(value = "idp") long idp) {
			Optional<Torneio> torneio = torneioRepository.findById(id);
			Optional<Partida> partida = repository.findById(idp);
			if (torneio.isPresent() && partida.isPresent()) {
				EventoPartida evento = new EventoPartida();
				evento.setNome("inicio");
				evento.setValor("1");

				var retorno = eventoRepository.save(evento);
				Partida partidas = partida.get();
				partidas.getEventos().add(retorno);
				repository.save(partidas);
				return new ResponseEntity<>("Evento salvo com sucesso!", HttpStatus.OK);
			} else
				return new ResponseEntity<>("Não existe esse torneio ou partida", HttpStatus.NOT_FOUND);
		}
		
		@RequestMapping(value = "/torneios/{id}/partidas/{idp}/eventos/gol", method = RequestMethod.POST)
		public ResponseEntity<Object> salvarEventoGol(@PathVariable(value = "id") long id,
				@PathVariable(value = "idp") long idp) {
			Optional<Torneio> torneio = torneioRepository.findById(id);
			Optional<Partida> partida = repository.findById(idp);
			if (torneio.isPresent() && partida.isPresent()) {
				EventoPartida evento = new EventoPartida();
				evento.setNome("gol");
				evento.setValor("1");

				var retorno = eventoRepository.save(evento);
				Partida partidas = partida.get();
				partidas.getEventos().add(retorno);
				repository.save(partidas);
				return new ResponseEntity<>("Evento salvo com sucesso!", HttpStatus.OK);
			} else
				return new ResponseEntity<>("Não existe esse torneio ou partida", HttpStatus.NOT_FOUND);
		}
		
		@RequestMapping(value = "/torneios/{id}/partidas/{idp}/eventos/intervalo", method = RequestMethod.POST)
		public ResponseEntity<Object> salvarEventoIntervalo(@PathVariable(value = "id") long id,
				@PathVariable(value = "idp") long idp) {
			Optional<Torneio> torneio = torneioRepository.findById(id);
			Optional<Partida> partida = repository.findById(idp);
			if (torneio.isPresent() && partida.isPresent()) {
				EventoPartida evento = new EventoPartida();
				evento.setNome("intervalo");
				evento.setValor("1");

				var retorno = eventoRepository.save(evento);
				Partida partidas = partida.get();
				partidas.getEventos().add(retorno);
				repository.save(partidas);
				return new ResponseEntity<>("Evento salvo com sucesso!", HttpStatus.OK);
			} else
				return new ResponseEntity<>("Não existe esse torneio ou partida", HttpStatus.NOT_FOUND);
		}
		
		@RequestMapping(value = "/torneios/{id}/partidas/{idp}/eventos/acrescimo", method = RequestMethod.POST)
		public ResponseEntity<Object> salvarEventoAcrecimo(@PathVariable(value = "id") long id,
				@PathVariable(value = "idp") long idp) {
			Optional<Torneio> torneio = torneioRepository.findById(id);
			Optional<Partida> partida = repository.findById(idp);
			if (torneio.isPresent() && partida.isPresent()) {
				EventoPartida evento = new EventoPartida();
				evento.setNome("acrescimo");
				evento.setValor("1");

				var retorno = eventoRepository.save(evento);
				Partida partidas = partida.get();
				partidas.getEventos().add(retorno);
				repository.save(partidas);
				return new ResponseEntity<>("Evento salvo com sucesso!", HttpStatus.OK);
			} else
				return new ResponseEntity<>("Não existe esse torneio ou partida", HttpStatus.NOT_FOUND);
		}
		
		@RequestMapping(value = "/torneios/{id}/partidas/{idp}/eventos/substituicao", method = RequestMethod.POST)
		public ResponseEntity<Object> salvarEventoSubstituicao(@PathVariable(value = "id") long id,
				@PathVariable(value = "idp") long idp) {
			Optional<Torneio> torneio = torneioRepository.findById(id);
			Optional<Partida> partida = repository.findById(idp);
			if (torneio.isPresent() && partida.isPresent()) {
				EventoPartida evento = new EventoPartida();
				evento.setNome("substituicao");
				evento.setValor("1");

				var retorno = eventoRepository.save(evento);
				Partida partidas = partida.get();
				partidas.getEventos().add(retorno);
				repository.save(partidas);
				return new ResponseEntity<>("Evento salvo com sucesso!", HttpStatus.OK);
			} else
				return new ResponseEntity<>("Não existe esse torneio ou partida", HttpStatus.NOT_FOUND);
		}
		
		@RequestMapping(value = "/torneios/{id}/partidas/{idp}/eventos/advertencia", method = RequestMethod.POST)
		public ResponseEntity<Object> salvarEventoAdvertencia(@PathVariable(value = "id") long id,
				@PathVariable(value = "idp") long idp) {
			Optional<Torneio> torneio = torneioRepository.findById(id);
			Optional<Partida> partida = repository.findById(idp);
			if (torneio.isPresent() && partida.isPresent()) {
				EventoPartida evento = new EventoPartida();
				evento.setNome("advertencia");
				evento.setValor("1");

				var retorno = eventoRepository.save(evento);
				Partida partidas = partida.get();
				partidas.getEventos().add(retorno);
				repository.save(partidas);
				return new ResponseEntity<>("Evento salvo com sucesso!", HttpStatus.OK);
			} else
				return new ResponseEntity<>("Não existe esse torneio ou partida", HttpStatus.NOT_FOUND);
		}
		
		@RequestMapping(value = "/torneios/{id}/partidas/{idp}/eventos/fim", method = RequestMethod.POST)
		public ResponseEntity<Object> salvarEventoFim(@PathVariable(value = "id") long id,
				@PathVariable(value = "idp") long idp) {
			Optional<Torneio> torneio = torneioRepository.findById(id);
			Optional<Partida> partida = repository.findById(idp);
			if (torneio.isPresent() && partida.isPresent()) {
				EventoPartida evento = new EventoPartida();
				evento.setNome("fim");
				evento.setValor("1");

				var retorno = eventoRepository.save(evento);
				Partida partidas = partida.get();
				partidas.getEventos().add(retorno);
				repository.save(partidas);
				return new ResponseEntity<>("Evento salvo com sucesso!", HttpStatus.OK);
			} else
				return new ResponseEntity<>("Não existe esse torneio ou partida", HttpStatus.NOT_FOUND);
		}
		
		@RequestMapping(value = "/torneios/{id}/partidas/{idp}/eventos/faltas", method = RequestMethod.POST)
		public ResponseEntity<Object> salvarEventoFaltas(@PathVariable(value = "id") long id,
				@PathVariable(value = "idp") long idp) {
			Optional<Torneio> torneio = torneioRepository.findById(id);
			Optional<Partida> partida = repository.findById(idp);
			if (torneio.isPresent() && partida.isPresent()) {
				EventoPartida evento = new EventoPartida();
				evento.setNome("faltas");
				evento.setValor("1");

				var retorno = eventoRepository.save(evento);
				Partida partidas = partida.get();
				partidas.getEventos().add(retorno);
				repository.save(partidas);
				return new ResponseEntity<>("Evento salvo com sucesso!", HttpStatus.OK);
			} else
				return new ResponseEntity<>("Não existe esse torneio ou partida", HttpStatus.NOT_FOUND);
		}
}
