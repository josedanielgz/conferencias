package com.ufps.conferencia.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Chair extends Usuario {

	@OneToOne
	@JoinColumn(name = "conferencia_id")
	@JsonBackReference
	private Conferencia conferencia;

	public Chair() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chair(Long id, String nombre, String apellido, String email, String password, 
			LocalDate fechaInscripcion) {
		super(id, nombre, apellido, email, password, fechaInscripcion);
		// TODO Auto-generated constructor stub
	}

	public Conferencia getConferencia() {
		return conferencia;
	}

	public void setConferencia(Conferencia conferencia) {
			this.conferencia = conferencia;
		}

}