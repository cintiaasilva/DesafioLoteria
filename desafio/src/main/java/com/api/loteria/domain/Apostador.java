package com.api.loteria.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class Apostador implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numeros_sorteados")
	@JsonProperty
	private ArrayList<Long> numerosSorteados;
	
	@Column(name = "email")
	@JsonProperty
	private String email;

	public Long getId() {
		return id;
	}

	public ArrayList<Long> getNumerosSorteados() {
		return numerosSorteados;
	}

	public void setNumerosSorteados(ArrayList<Long> numerosSorteados) {
		this.numerosSorteados = numerosSorteados;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Apostador(ArrayList<Long> numerosSorteados, String email) {
		this.numerosSorteados = numerosSorteados;
		this.email = email;
	}

	public Apostador() {
	}
	
	
	
	
}
