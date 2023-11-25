package com.ufps.conferencia.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.ufps.conferencia.entity.Asistente;
import com.ufps.conferencia.entity.Conferencia;

public interface ConferenciaService {
	public Conferencia guardar(Conferencia unaConferencia);

	public Optional<Conferencia> buscar(Long idConferencia);

	public void eliminar(Long idConferencia);

	public Long diasDeRegistro(Conferencia unConferencia);

	public List<Conferencia> listaDeConferencias();

	public List<Conferencia> conferenciasDentroDePlazoDeEntrega(LocalDate fechaInicial, LocalDate fechaFinal);
	
	public List<Asistente> asistentesDeLaConferencia(Conferencia unConferencia);

}
