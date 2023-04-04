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
@Table(name = "tb_jogador")
public class Jogador implements Serializable{
	
	private static final long serialVersionUID = -2100397410579642292L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String name;

	@Column(name = "dataNascimento")
	private Date dataNascimento;
	
	
	@Column(name = "pais")
	private String pais;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Transferencia> transferencias;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Transferencia> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(List<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}

	public Jogador(Long id, String name, Date dataNascimento, String pais, List<Transferencia> transferencias) {
		super();
		this.id = id;
		this.name = name;
		this.dataNascimento = dataNascimento;
		this.pais = pais;
		this.transferencias = transferencias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento, id, name, pais, transferencias);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(pais, other.pais)
				&& Objects.equals(transferencias, other.transferencias);
	}

	public Jogador() {
		super();
	}

}
