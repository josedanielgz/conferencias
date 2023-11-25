/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

	public Chair(Long id, String nombre, String apellido, String email, String password, Rol roles,
			LocalDate fechaInscripcion) {
		super(id, nombre, apellido, email, password, roles, fechaInscripcion);
		// TODO Auto-generated constructor stub
	}

	public Conferencia getConferencia() {
		return conferencia;
	}

	public void setConferencia(Conferencia conferencia) {
		this.conferencia = conferencia;
	}

}
