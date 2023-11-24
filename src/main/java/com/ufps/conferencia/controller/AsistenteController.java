/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.conferencia.controller;

import com.ufps.conferencia.entity.Asistente;
import com.ufps.conferencia.repository.AsistenteRepository;
import com.ufps.conferencia.repository.ChairRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asistente")
public class AsistenteController {

    @Autowired
    AsistenteRepository asistenteRepository;
    
    public List<Asistente> getAsistenteAll() {

        return asistenteRepository.findAll();
    }

    @PostMapping
    public Asistente postAsistente(@RequestBody Asistente asistente) {

        asistenteRepository.save(asistente);

        return asistente;

    }

    @PutMapping("/{id}")
    public Asistente putAsistentebyId(@PathVariable Long id, @RequestBody Asistente asistente) {

        Optional<Asistente> asistenteCurrent = asistenteRepository.findById(id);

        if (asistenteCurrent.isPresent()) {

            Asistente asistenteReturn = asistenteCurrent.get();

            asistenteReturn.setNombre(asistente.getNombre());
            asistenteReturn.setApellido(asistente.getApellido());
            asistenteReturn.setEmail(asistente.getEmail());
            asistenteReturn.setEmail(asistente.getPassword());

            asistenteRepository.save(asistenteReturn);

            return asistenteReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Asistente deleteAsistentebyId(@PathVariable Long id) {

        Optional<Asistente> asistente = asistenteRepository.findById(id);

        if (asistente.isPresent()) {

            Asistente asistenteReturn = asistente.get();

            asistenteRepository.deleteById(id);

            return asistenteReturn;
        }

        return null;

    }
}
