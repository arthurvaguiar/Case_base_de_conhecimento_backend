package com.casespringboot.api.rest;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.casespringboot.api.rest.resources.TopicoResource;
import com.casespringboot.domain.entities.Topico;
import com.casespringboot.domain.enums.Categoria;
import com.casespringboot.domain.services.TopicoService;

@Controller
@RequestMapping(value = "/topicos")
public class TopicoEndpoint {

	@Autowired
	private TopicoService service;

	/*
	 * @GetMapping public ResponseEntity<List<Topico>> findlAll() { List<Topico>
	 * list = service.findAll(); return ResponseEntity.ok().body(list); }
	 */

	@GetMapping(value = "/{id}")
	public ResponseEntity<TopicoResource> findById(@PathVariable Long id) {
		Topico topico = service.findById(id);
		return ResponseEntity.ok().body(new TopicoResource(topico));
	}

	@PostMapping
	public ResponseEntity<TopicoResource> insert(@RequestBody @Valid TopicoResource topicoResource) {
		Topico topico = service.insert(topicoResource.toEntity());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoResource(topico));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TopicoResource> update(@PathVariable Long id, @RequestBody TopicoResource topicoResource) {
		Topico topico = service.update(id, topicoResource.toEntity());
		return ResponseEntity.ok().body(new TopicoResource(topico));
	}

	@GetMapping
	public ResponseEntity<Page<TopicoResource>> findByParameters(
			@RequestParam(value = "titulo", required = false) String titulo,
			@RequestParam(value = "categoria", required = false) Categoria categoria,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "limit", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "dataCriacao") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		Page<Topico> listTopicos = service.findByParameters(titulo, categoria, page, linesPerPage, orderBy, direction);
		Page<TopicoResource> pageTopicoResource = listTopicos.map(topico -> new TopicoResource(topico));
		return ResponseEntity.ok().body(pageTopicoResource);
	}

}
