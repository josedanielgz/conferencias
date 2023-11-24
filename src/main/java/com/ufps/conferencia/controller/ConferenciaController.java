/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.conferencia.controller;



import com.ufps.conferencia.entity.Conferencia;
import com.ufps.conferencia.repository.ConferenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conferencia")
public class ConferenciaController {

    @Autowired
    ConferenciaRepository conferenciaRepository;
    
         @GetMapping("/all")
    public List<Conferencia> getChairAll() {

        return conferenciaRepository.findAll();
    }
}
