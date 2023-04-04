package com.puc.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_partidas")
public class Partida implements Serializable{
	
	private static final long serialVersionUID = 580376094065744703L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

	@Column(name = "dataPartida")
	private Date dataPartida;
	
	
	@Column(name = "cidade")
	private String cidade;
	
	@OneToOne
	private TimeFutebol timePrimeiro;

	@OneToOne
	private TimeFutebol timeSegundo;
	
	@OneToMany
	private List<EventoPartida> eventos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public TimeFutebol getTimePrimeiro() {
		return timePrimeiro;
	}

	public void setTimePrimeiro(TimeFutebol timePrimeiro) {
		this.timePrimeiro = timePrimeiro;
	}

	public TimeFutebol getTimeSegundo() {
		return timeSegundo;
	}

	public void setTimeSegundo(TimeFutebol timeSegundo) {
		this.timeSegundo = timeSegundo;
	}

	public List<EventoPartida> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoPartida> eventos) {
		this.eventos = eventos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade, dataPartida, eventos, id, timePrimeiro, timeSegundo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(dataPartida, other.dataPartida)
				&& Objects.equals(eventos, other.eventos) && Objects.equals(id, other.id)
				&& Objects.equals(timePrimeiro, other.timePrimeiro) && Objects.equals(timeSegundo, other.timeSegundo);
	}

	public Partida(Long id, Date dataPartida, String cidade, TimeFutebol timePrimeiro, TimeFutebol timeSegundo,
			List<EventoPartida> eventos) {
		super();
		this.id = id;
		this.dataPartida = dataPartida;
		this.cidade = cidade;
		this.timePrimeiro = timePrimeiro;
		this.timeSegundo = timeSegundo;
		this.eventos = eventos;
	}

	public Partida() {
		super();
	} 
	
	
}
