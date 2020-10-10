package com.casespringboot.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casespringboot.entities.Topico;
import com.casespringboot.repositories.TopicoRepository;
import com.casespringboot.services.exceptions.ResourceNotFoundException;

@Service
public class TopicoService {
	
	@Autowired
	private TopicoRepository repository;
	
	public List<Topico> findAll(){
		return repository.findAll();
	}

	public Topico findById(Long id) {
		Optional<Topico> obj =  repository.findById(id);
		return obj.get();
	}
	
	
	public Topico insert(Topico obj) {
		return repository.save(obj);
	}


	public Topico update(Long id, Topico obj) {
		try {
			Topico entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	private void updateData(Topico entity, Topico obj) {
		entity.setTitulo(obj.getTitulo());
		entity.setConteudo(obj.getConteudo());

	}

	public List<Topico> findByTituloContainingIgnoreCase(String titulo) {
		return repository.findByTituloContainingIgnoreCase(titulo);
	}


	
	
	
	
}
