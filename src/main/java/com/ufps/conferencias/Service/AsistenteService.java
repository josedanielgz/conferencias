package com.ufps.conferencias.Service;

import java.util.List;
import java.util.Optional;

import com.ufps.conferencias.Entity.Asistente;

public interface AsistenteService {

	public Asistente guardar(Asistente unAsistente);
	public Optional<Asistente> buscar(Long idAsistente);
	public void eliminar(Long idAsistente);
	public Long diasDeRegistro(Asistente unAsistente);
	public List<Asistente> listaDeAsistentes();
	
}
