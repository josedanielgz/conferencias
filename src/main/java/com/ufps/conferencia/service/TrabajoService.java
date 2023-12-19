package com.ufps.conferencia.service;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.springframework.web.multipart.MultipartFile;

import com.ufps.conferencia.entity.Trabajo;

public interface TrabajoService {

	public Trabajo subirTrabajo(Long conferenceId, Long participantId, MultipartFile file) throws HibernateException, IOException;
}
