package com.puc.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_transferencia")
public class Transferencia implements Serializable{

	private static final long serialVersionUID = -767756258599190454L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
	
	@OneToOne
	private TimeFutebol timeOrigem;
	
	@OneToOne
	private TimeFutebol timeDestino;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "valor")
	private Float valor;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TimeFutebol getTimeOrigem() {
		return timeOrigem;
	}

	public void setTimeOrigem(TimeFutebol timeOrigem) {
		this.timeOrigem = timeOrigem;
	}

	public TimeFutebol getTimeDestino() {
		return timeDestino;
	}

	public void setTimeDestino(TimeFutebol timeDestino) {
		this.timeDestino = timeDestino;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, id, timeDestino, timeOrigem, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transferencia other = (Transferencia) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(timeDestino, other.timeDestino) && Objects.equals(timeOrigem, other.timeOrigem)
				&& Objects.equals(valor, other.valor);
	}

	public Transferencia(Long id, TimeFutebol timeOrigem, TimeFutebol timeDestino, Date data, Float valor) {
		super();
		this.id = id;
		this.timeOrigem = timeOrigem;
		this.timeDestino = timeDestino;
		this.data = data;
		this.valor = valor;
	}

	public Transferencia() {
		super();
	}


	
}
