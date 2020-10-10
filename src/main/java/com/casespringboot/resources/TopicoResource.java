package com.casespringboot.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.casespringboot.entities.Topico;
import com.casespringboot.services.TopicoService;

@Controller
@RequestMapping(value = "/topicos")
public class TopicoResource {
	
	
	@Autowired
	private TopicoService service;

	@GetMapping
	public ResponseEntity<List<Topico>> findlAll(){
		List <Topico> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Topico> findById(@PathVariable Long id){
		Topico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Topico> insert(@RequestBody Topico obj){
		obj = service.insert(obj);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Topico> update(@PathVariable Long id, @RequestBody Topico obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{titulo}")
	public List<Topico> findByTitulo(@PathVariable String titulo){
		return service.findByTituloContainingIgnoreCase(titulo);
	}
	
}
