package com.api.loteria.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.transaction.annotation.Transactional;


import com.api.loteria.domain.Apostador;
import com.api.loteria.repository.LoteriaRepository;
import com.api.loteria.services.LoteriaService;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/emails")
public class LoteriaController {
	
	@Autowired
	private LoteriaRepository loteriaRepository;
	
	@Autowired
	private LoteriaService loteriaService;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<Apostador> cadastrarSorteio(@RequestBody Apostador fichaSorteio){
		
		ArrayList<Long> numerosSorteados;
		numerosSorteados = loteriaService.sortearNumeros();
		fichaSorteio.setNumerosSorteados(numerosSorteados);
		loteriaRepository.save(fichaSorteio);
		return ResponseEntity.status(HttpStatus.CREATED).body(fichaSorteio);
	}
	
	@GetMapping
	@Transactional
	public ResponseEntity<List<Apostador>> buscarTodosSorteios(){
		if (loteriaRepository.count() > 0) {
			List<Apostador> fichasSorteios = loteriaRepository.findAll();
			return ResponseEntity.ok().body(fichasSorteios);
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping ("/{email}")
	@Transactional
	public ResponseEntity<List<Apostador>> listarSorteioPorSolicitante(@PathVariable String email){
		
		if (!(loteriaRepository.count() > 0)) {
			return ResponseEntity.noContent().build();
		}
		
		List<Apostador> fichasSorteios = loteriaRepository.buscaFichaSorteioPeloEmail(email);
	
		if(fichasSorteios.size() > 0) {
			return ResponseEntity.ok().body(fichasSorteios);
		} else {
			return ResponseEntity.noContent().build();
		}	
	}
}
