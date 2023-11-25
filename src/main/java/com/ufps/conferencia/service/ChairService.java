package com.ufps.conferencia.service;

import java.util.List;
import java.util.Optional;

import com.ufps.conferencia.entity.Chair;

public interface ChairService {
	
	public List<Chair> listaDeChair();
	public Optional<Chair> buscar(Long id);
	public void eliminar(Long id);

}
