package com.api.loteria.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class LoteriaService {
	
	private long geraNumeroAleatorio() {
		double numero = Math.random() *  9;
		return (long) numero; 
	}
	
	public ArrayList<Long> sortearNumeros() {
		
		ArrayList<Long> numerosSorteados = new ArrayList<Long>();
		
		for(int i=0; i <=2; i++) {
			numerosSorteados.add(geraNumeroAleatorio());
		}
		return numerosSorteados;
	}
}
