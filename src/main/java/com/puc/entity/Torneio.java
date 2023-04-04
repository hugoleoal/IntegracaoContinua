package com.puc.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_torneios")
public class Torneio implements Serializable{
	
	private static final long serialVersionUID = 5283183423958336622L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String name;

	@Column(name = "dataTorneio")
	private Date dataTorneio;
	
	
	@Column(name = "cidade")
	private String cidade;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<TimeFutebol> times;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Partida> partidas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDataTorneio() {
		return dataTorneio;
	}

	public void setDataTorneio(Date dataTorneio) {
		this.dataTorneio = dataTorneio;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<TimeFutebol> getTimes() {
		return times;
	}

	public void setTimes(List<TimeFutebol> times) {
		this.times = times;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade, dataTorneio, id, name, partidas, times);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torneio other = (Torneio) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(dataTorneio, other.dataTorneio)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(partidas, other.partidas) && Objects.equals(times, other.times);
	}

	public Torneio(Long id, String name, Date dataTorneio, String cidade, List<TimeFutebol> times,
			List<Partida> partidas) {
		super();
		this.id = id;
		this.name = name;
		this.dataTorneio = dataTorneio;
		this.cidade = cidade;
		this.times = times;
		this.partidas = partidas;
	}

	public Torneio() {
		super();
	}

	
}
