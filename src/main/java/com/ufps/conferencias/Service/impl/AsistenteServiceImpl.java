package com.ufps.conferencias.Service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ufps.conferencias.Entity.Asistente;
import com.ufps.conferencias.Repository.AsistenteRepository;
import com.ufps.conferencias.Service.AsistenteService;

public class AsistenteServiceImpl implements AsistenteService {
	
	@Autowired
	AsistenteRepository asistenteRepositorio;

	@Override
	public Asistente guardar(Asistente unAsistente) {
		// TODO Auto-generated method stub
		return this.asistenteRepositorio.save(unAsistente);
	}

	@Override
	public Optional<Asistente> buscar(Long idAsistente) {
		return this.asistenteRepositorio.findById(idAsistente);
	}

	@Override
	public void eliminar(Long idAsistente) {
		this.asistenteRepositorio.deleteById(idAsistente);

	}
	
	public List<Asistente> listaDeAsistentes(){
		return this.asistenteRepositorio.findAll();
	}

	@Override
	public Long diasDeRegistro(Asistente unAsistente) {
		return ChronoUnit.DAYS.between(unAsistente.getFecha_inscripcion(), LocalDate.now());
	}

}
