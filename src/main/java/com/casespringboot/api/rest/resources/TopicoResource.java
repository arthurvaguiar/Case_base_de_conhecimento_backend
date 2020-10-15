package com.casespringboot.api.rest.resources;

import java.time.LocalDateTime;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.casespringboot.domain.entities.Topico;
import com.casespringboot.domain.enums.Categoria;

@Resource
public class TopicoResource {

	private Long id;
	
	private String titulo;

	private String conteudo;

	private LocalDateTime moment;

	private boolean status;

	private Categoria categoria;

	
	public Long getId() {
		return id;
	}

	public TopicoResource() {
	}

	public String getTitulo() {
		return titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public boolean isStatus() {
		return status;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Topico toEntity() {
		Topico topico = new Topico();
		topico.setId(this.id);
		topico.setTitulo(this.titulo);
		topico.setConteudo(this.conteudo);
		topico.setDataCriacao(LocalDateTime.now());
		topico.setStatus(this.status);
		topico.setCategoria(this.categoria);

		return topico;
	}

	public TopicoResource(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.conteudo = topico.getConteudo();
		this.moment = topico.getDataCriacao();
		this.status = topico.isStatus();
		this.categoria = topico.getCategoria();
	}

}
