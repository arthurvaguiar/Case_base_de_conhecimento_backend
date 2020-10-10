package com.casespringboot.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casespringboot.domain.entities.Topico;
import com.casespringboot.domain.enums.Categoria;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long>{
	
	
	public Page<Topico> findByTituloContainingIgnoreCaseAndCategoria(String titulo, Categoria categoria, Pageable pageable);
	public Page<Topico> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
	public Page<Topico> findByCategoria(Categoria categoria, Pageable pageable);
	
	
	
	 

}
