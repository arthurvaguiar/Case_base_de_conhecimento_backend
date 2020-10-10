package com.casespringboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.casespringboot.entities.Topico;
import com.casespringboot.entities.enums.Categoria;
import com.casespringboot.entities.enums.Status;
import com.casespringboot.repositories.TopicoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	
	@Autowired
	private TopicoRepository topicoRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		Topico t1 = new Topico(null, "Teste", "Teste", Categoria.COMPRAS, Status.ATIVO);
		
		topicoRepository.saveAll(Arrays.asList(t1));
		
	

	}

}
