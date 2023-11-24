/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.conferencia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Asistente extends Usuario {

    private String ciudad;
    private String pais;
    private String institucion;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    
    public Asistente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asistente(Long id, String nombre, String apellido, String email, String password, Rol roles,
			LocalDate fechaInscripcion) {
		super(id, nombre, apellido, email, password, roles, fechaInscripcion);
		// TODO Auto-generated constructor stub
	}

	@ManyToMany(mappedBy = "asistentes")
    private List<Conferencia> conferencias;

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public List<Conferencia> getConferencias() {
		return conferencias;
	}

	public void setConferencias(List<Conferencia> conferencias) {
		this.conferencias = conferencias;
	}

    // Getters y setters
    
}

