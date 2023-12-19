package com.ufps.conferencia.service.impl;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.ufps.conferencia.entity.Trabajo;
import com.ufps.conferencia.repository.TrabajoRepository;
import com.ufps.conferencia.service.TrabajoService;

import jakarta.transaction.Transactional;

public class TrabajoServiceImpl implements TrabajoService {
	
	 private final TrabajoRepository submitRepository;
	  private final SessionFactory sessionFactory;

	  @Autowired
	  public TrabajoServiceImpl(TrabajoRepository submitRepository, SessionFactory sessionFactory) {
	      this.submitRepository = submitRepository;
	      this.sessionFactory = sessionFactory;
	  }

	  @Transactional
	  public Trabajo submitWork(Long conferenceId, Long participantId, MultipartFile file) throws HibernateException, IOException {
	      Trabajo submit = new Trabajo();
	      submit.setConferenciaId(conferenceId);
	      submit.setParticipanteId(participantId);
	      submit.setArchivo(sessionFactory.getCurrentSession().getLobHelper().createBlob(file.getInputStream(), file.getSize()));
	      return submitRepository.save(submit);
	  }

}
