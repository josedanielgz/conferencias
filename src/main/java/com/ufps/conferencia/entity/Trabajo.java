package com.ufps.conferencia.entity;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "trabajos")
public class Trabajo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long conferenciaId;
	private Long participanteId;
	@Lob
	private Blob archivo;
	
	public Trabajo() {
		super();
	}

	public Trabajo(Long id, Long conferenciaId, Long participanteId, Blob archivo) {
		super();
		this.id = id;
		this.conferenciaId = conferenciaId;
		this.participanteId = participanteId;
		this.archivo = archivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getConferenciaId() {
		return conferenciaId;
	}

	public void setConferenciaId(Long conferenciaId) {
		this.conferenciaId = conferenciaId;
	}

	public Long getParticipanteId() {
		return participanteId;
	}

	public void setParticipanteId(Long participanteId) {
		this.participanteId = participanteId;
	}

	public Blob getArchivo() {
		return archivo;
	}

	public void setArchivo(Blob archivo) {
		this.archivo = archivo;
	}

}
