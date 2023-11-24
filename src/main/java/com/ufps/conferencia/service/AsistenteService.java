package com.ufps.conferencia.service;

import java.util.List;
import java.util.Optional;

import com.ufps.conferencia.entity.Asistente;

public interface AsistenteService {

	public Asistente guardar(Asistente unAsistente);
	public Optional<Asistente> buscar(Long idAsistente);
	public void eliminar(Long idAsistente);
	public Long diasDeRegistro(Asistente unAsistente);
	public List<Asistente> listaDeAsistentes();
	
}
