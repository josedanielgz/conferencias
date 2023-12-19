package com.ufps.conferencia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ufps.conferencia.entity.Chair;
import com.ufps.conferencia.repository.ChairRepository;
import com.ufps.conferencia.service.ChairService;

public class ChairServiceImpl implements ChairService {
	
	@Autowired
	ChairRepository repositorio;

	@Override
	public Optional<Chair> buscar(Long id) {
		return this.repositorio.findById(id);
	}

	@Override
	public void eliminar(Long id) {
		this.repositorio.deleteById(id);
		
	}

	@Override
	public List<Chair> listaDeChair() {
		return this.repositorio.findAll();
	}

}