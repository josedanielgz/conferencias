/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.conferencia.controller;

import com.ufps.conferencia.entity.Asistente;
import com.ufps.conferencia.entity.Conferencia;
import com.ufps.conferencia.entity.Trabajo;
import com.ufps.conferencia.repository.AsistenteRepository;
import com.ufps.conferencia.service.AsistenteService;
import com.ufps.conferencia.service.TrabajoService;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/asistente")
public class AsistenteController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	AsistenteService asistenteRepository;

	@Autowired
	TrabajoService trabajoService;

	@GetMapping("/usuarios")
	public List<Asistente> getClienteAll() {

		return asistenteRepository.listaDeAsistentes();
	}

	@PostMapping
	public Asistente postNews(@RequestBody Asistente asistente) {

		asistenteRepository.guardar(asistente);

		return asistente;

	}

	@PutMapping("/{idAsistente}")
	public Asistente putClientebyId(@PathVariable Long idAsistente, @RequestBody Asistente asistente) {

		Optional<Asistente> asistenteCurrent = this.asistenteRepository.buscar(idAsistente);

		if (asistenteCurrent.isPresent()) {

			Asistente asistenteReturn = asistenteCurrent.get();

			asistenteReturn.setNombre(asistente.getNombre());
			asistenteReturn.setApellido(asistente.getApellido());
			asistenteReturn.setInstitucion(asistente.getInstitucion());
			asistenteReturn.setEmail(asistente.getEmail());
			asistenteReturn.setCiudad(asistente.getCiudad());
			asistenteReturn.setPais(asistente.getPais());
			asistenteReturn.setPassword(asistente.getPassword());

			asistenteRepository.guardar(asistenteReturn);

			return asistenteReturn;
		}

		return null;

	}

	@PutMapping("/registro/{idAsistente}")
	public Asistente registrarseEnConvocatoria(@PathVariable Long idAsistente, @RequestBody Asistente asistente) {

		Optional<Asistente> asistenteCurrent = this.asistenteRepository.buscar(idAsistente);

		if (asistenteCurrent.isPresent()) {

			Asistente asistenteReturn = asistenteCurrent.get();

			asistenteReturn.setNombre(asistente.getNombre());
			asistenteReturn.setApellido(asistente.getApellido());
			asistenteReturn.setInstitucion(asistente.getInstitucion());
			asistenteReturn.setEmail(asistente.getEmail());
			asistenteReturn.setCiudad(asistente.getCiudad());
			asistenteReturn.setPais(asistente.getPais());
			asistenteReturn.setPassword(asistente.getPassword());

			asistenteRepository.guardar(asistenteReturn);

			return asistenteReturn;
		}

		return null;

	}

	@DeleteMapping("/{idAsistente}")
	public Asistente deleteNewsbyId(@PathVariable Long idAsistente) {

		Optional<Asistente> asistente = asistenteRepository.buscar(idAsistente);

		if (asistente.isPresent()) {

			Asistente asistenteReturn = asistente.get();

			asistenteRepository.eliminar(idAsistente);

			return asistenteReturn;
		}

		return null;

	}

	@GetMapping("/fecha/{idAsistente}")
	public String daysSinceRegistered(@PathVariable Long idAsistente) {

		Optional<Asistente> asistente = asistenteRepository.buscar(idAsistente);
		if (asistente.isPresent()) {
			Long dias = this.asistenteRepository.diasDeRegistro(asistente.get());
			return "";
		}
		return null;
	}

	@PutMapping("/trabajo/{conferenciaId}")
	public Trabajo registrarTrabajoConvocatoria(@RequestParam Long conferenciaId, @RequestBody Asistente asistente,
			@RequestParam MultipartFile file) {
		try {
			return this.trabajoService.subirTrabajo(conferenciaId, conferenciaId, file);
		} catch (HibernateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Conferencia obtenerConferencia(Long conferenciaId) {
		String url = "http://conferencia-service/api/conferencias/" + conferenciaId;
		return restTemplate.getForObject(url, Conferencia.class);

	}

}
