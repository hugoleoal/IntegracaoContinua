package com.puc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_evento")
public class EventoPartida implements Serializable{

	private static final long serialVersionUID = 5814862964707626769L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

	@Column(name = "nome")
	private String nome;
	
	
	@Column(name = "valor")
	private String valor;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, nome, valor);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventoPartida other = (EventoPartida) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(valor, other.valor);
	}


	public EventoPartida(Long id, String nome, String valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}


	public EventoPartida() {
		super();
	}

	
}
