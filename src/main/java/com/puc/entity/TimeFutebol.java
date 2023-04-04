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
@Table(name = "tb_time")
public class TimeFutebol implements Serializable{
	
	private static final long serialVersionUID = -2182369628240398632L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID", nullable = false)
	    private Long id;

	    @Column(name = "nome", length = 50, nullable = false)
	    private String name;
	    
	    @Column(name = "localidade", length = 50, nullable = false)
	    private String localidade;

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

		public String getLocalidade() {
			return localidade;
		}

		public void setLocalidade(String localidade) {
			this.localidade = localidade;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, localidade, name);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TimeFutebol other = (TimeFutebol) obj;
			return Objects.equals(id, other.id) && Objects.equals(localidade, other.localidade)
					&& Objects.equals(name, other.name);
		}

		public TimeFutebol(Long id, String name, String localidade) {
			super();
			this.id = id;
			this.name = name;
			this.localidade = localidade;
		}

		public TimeFutebol() {
			super();
		}
	  
	    
}
