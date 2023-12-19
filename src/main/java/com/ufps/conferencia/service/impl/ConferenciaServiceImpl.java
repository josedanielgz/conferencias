package com.ufps.conferencia.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ufps.conferencia.entity.Asistente;
import com.ufps.conferencia.entity.Conferencia;
import com.ufps.conferencia.repository.ConferenciaRepository;
import com.ufps.conferencia.service.ConferenciaService;

public class ConferenciaServiceImpl implements ConferenciaService {
	
	@Autowired
	ConferenciaRepository repositorio;

	@Override
	public Conferencia guardar(Conferencia unaConferencia) {
		return this.repositorio.save(unaConferencia);
	}

	@Override
	public Optional<Conferencia> buscar(Long idConferencia) {
		return this.repositorio.findById(idConferencia);
	}

	@Override
	public void eliminar(Long idConferencia) {
		this.repositorio.deleteById(idConferencia);
		
	}

	@Override
	public Long diasDeRegistro(Conferencia unConferencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Conferencia> listaDeConferencias() {
		// TODO Auto-generated method stub
		return this.repositorio.findAll();
	}

	@Override
	public List<Conferencia> conferenciasDentroDePlazoDeEntrega(LocalDate fechaInicial, LocalDate fechaFinal) {
		return this.repositorio.findByPlazoEnvioTrabajosBetween(fechaInicial, fechaFinal);
	}

	@Override
	public List<Asistente> asistentesDeLaConferencia(Conferencia unConferencia) {
		// TODO Auto-generated method stub
		return unConferencia.getAsistentes();
	}


}
