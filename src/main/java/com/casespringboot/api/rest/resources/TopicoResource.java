package com.casespringboot.api.rest.resources;

import java.time.LocalDateTime;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.casespringboot.domain.entities.Topico;
import com.casespringboot.domain.enums.Categoria;

@Resource
public class TopicoResource {

	@NotNull(message = "Titulo obrigatório")
	@Size(min=5, max=100, message = "Quantidade máxima de 100 caracteres e minima de 5 caracteres")
	private String titulo;

	@NotNull(message = "Conteúdo obrigatório")
	@Size(max = 15000, min = 50, message = "Quantidade máxima de 15000 caracteres e minima de 50 caracteres")
	private String conteudo;

	private LocalDateTime moment;

	private boolean status;

	@NotNull(message = "Categoria obrigatório")
	private Categoria categoria;

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
		topico.setTitulo(this.titulo);
		topico.setConteudo(this.conteudo);
		topico.setDataCriacao(LocalDateTime.now());
		topico.setStatus(this.status);
		topico.setCategoria(this.categoria);

		return topico;
	}

	public TopicoResource(Topico topico) {
		this.titulo = topico.getTitulo();
		this.conteudo = topico.getConteudo();
		this.moment = topico.getDataCriacao();
		this.status = topico.isStatus();
		this.categoria = topico.getCategoria();
	}

}
