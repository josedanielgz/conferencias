/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.conferencia.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Conferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate plazoEnvioTrabajos;
	private LocalDate fechaCierre;

	@OneToOne(mappedBy = "conferencia")
	@JsonManagedReference
	private Chair chair;

	@ManyToMany
	@JoinTable(name = "usuario_conferencia", joinColumns = @JoinColumn(name = "conferencia_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	private List<Asistente> asistentes;
	
	public Conferencia() {
		super();
	}

	public Conferencia(Long id, String nombre, LocalDate fechaInicio, LocalDate plazoEnvioTrabajos,
			LocalDate fechaCierre, Chair chair, List<Asistente> asistentes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.plazoEnvioTrabajos = plazoEnvioTrabajos;
		this.fechaCierre = fechaCierre;
		this.chair = chair;
		this.asistentes = asistentes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getPlazoEnvioTrabajos() {
		return plazoEnvioTrabajos;
	}

	public void setPlazoEnvioTrabajos(LocalDate plazoEnvioTrabajos) {
		this.plazoEnvioTrabajos = plazoEnvioTrabajos;
	}

	public LocalDate getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Chair getChair() {
		return chair;
	}

	public void setChair(Chair chair) {
		this.chair = chair;
	}

	public List<Asistente> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List<Asistente> asistentes) {
		this.asistentes = asistentes;
	}

	// Otros campos y métodos
	
	
}
