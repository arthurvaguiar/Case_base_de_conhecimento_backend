package com.casespringboot.domain.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.casespringboot.domain.entities.Topico;
import com.casespringboot.domain.enums.Categoria;
import com.casespringboot.domain.exceptions.ResourceNotFoundException;
import com.casespringboot.domain.repositories.TopicoRepository;

@Service
public class TopicoService {

	@Autowired
	private TopicoRepository repository;

	public List<Topico> findAll() {
		return repository.findAll();
	}

	public Topico findById(Long id) {
		Optional<Topico> obj = repository.findById(id);
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
		entity.setId(obj.getId());
		entity.setTitulo(obj.getTitulo());
		entity.setConteudo(obj.getConteudo());
		entity.setStatus(obj.isStatus());
		entity.setCategoria(obj.getCategoria());
		entity.setDataCriacao(obj.getDataCriacao());

	}

	public Page<Topico> findByParameters(String titulo, Categoria categoria, Integer page, Integer linesPerPage,
			String orderBy, String direction) {
		Pageable pageable = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		if (!Strings.isEmpty(titulo) && categoria != null) {
			return repository.findByTituloContainingIgnoreCaseAndCategoria(titulo, categoria, pageable);
		} else if(!Strings.isEmpty(titulo)) {
			return repository.findByTituloContainingIgnoreCase(titulo, pageable);
		}else if(categoria !=null) {
			return repository.findByCategoria(categoria, pageable);
		}
		return repository.findAll(pageable);
	}

}
