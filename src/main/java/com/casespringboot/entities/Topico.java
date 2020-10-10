package com.casespringboot.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.casespringboot.entities.enums.Categoria;
import com.casespringboot.entities.enums.Status;

@Entity
@Table(name = "tb_topico")
public class Topico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String titulo;
	private String conteudo;
	
	private Integer categoria;
	
	private Integer status;
	

	public Topico() {

	}

	public Topico(Long id, String titulo, String conteudo, Categoria categoria, Status status) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
		setCategoria(categoria);
		setStatus(status);
	}

	public Categoria getCategoria() {
		return Categoria.valueOf(categoria);
	}

	public void setCategoria(Categoria categoria) {
		if(categoria != null) {
		this.categoria = categoria.getCode();
		}
	}
	public Status getStatus() {
		return Status.valueOf(status);
	}

	public void setStatus(Status status) {
		if(status != null) {
		this.status = status.getCode();
		}
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getConteudo() {
		return conteudo;
	}


	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
