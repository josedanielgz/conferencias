package com.ufps.conferencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufps.conferencia.entity.Asistente;
import com.ufps.conferencia.entity.Chair;
import com.ufps.conferencia.service.ChairService;
import com.ufps.conferencia.service.ConferenciaService;

@RestController
@RequestMapping("/chair")
public class ChairController {
    
     @Autowired
     ChairService chairService;
     
     @Autowired
     ConferenciaService conferenciaService;
     
     @GetMapping("/all")
    public List<Chair> getChairAll() {

        return chairService.listaDeChair();
    }
     
     @GetMapping("/asistentes")
     public List<Asistente> asistentesDeLaConferencia(@PathVariable Long id) {
    	 
    	 Chair elChair = this.chairService.buscar(id).get();

         return this.conferenciaService.asistentesDeLaConferencia(elChair.getConferencia());
     }
}