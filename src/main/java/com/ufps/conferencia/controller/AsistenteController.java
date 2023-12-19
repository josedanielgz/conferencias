/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.conferencia.controller;

import com.ufps.conferencia.entity.Asistente;
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
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/asistente")
public class AsistenteController {

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

	@PutMapping("/{id}")
	public Asistente putClientebyId(@PathVariable Long id, @RequestBody Asistente asistente) {

		Optional<Asistente> asistenteCurrent = this.asistenteRepository.buscar(id);

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

	@PutMapping("/{id}")
	public Asistente registrarseEnConvocatoria(@PathVariable Long id, @RequestBody Asistente asistente) {

		Optional<Asistente> asistenteCurrent = this.asistenteRepository.buscar(id);

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

	@DeleteMapping("/{id}")
	public Asistente deleteNewsbyId(@PathVariable Long id) {

		Optional<Asistente> asistente = asistenteRepository.buscar(id);

		if (asistente.isPresent()) {

			Asistente asistenteReturn = asistente.get();

			asistenteRepository.eliminar(id);

			return asistenteReturn;
		}

		return null;

	}

	@GetMapping("/fecha/{id}")
	public String daysSinceRegistered(@PathVariable Long id) {

		Optional<Asistente> asistente = asistenteRepository.buscar(id);
		if (asistente.isPresent()) {
			Long dias = this.asistenteRepository.diasDeRegistro(asistente.get());
			return "";
		}
		return null;
	}

	@PutMapping("/trabajo/{id}")
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

	/*
	 * @GetMapping("cliente/{id}") public Long edadCuentaDelCliente(@PathVariable
	 * Integer id) { Optional<Asistente> elCliente =
	 * this.clienteServicio.buscar(id); long diasDeCuenta =
	 * this.clienteServicio.diasDeRegistro(elCliente.get()); return diasDeCuenta; }
	 */
}
