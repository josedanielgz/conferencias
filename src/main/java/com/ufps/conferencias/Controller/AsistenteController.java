/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.conferencias.Controller;

import com.ufps.conferencias.Entity.Asistente;
import com.ufps.conferencias.Repository.AsistenteRepository;
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

    @GetMapping("/usuarios")
    public List<Asistente> getClienteAll() {

        return asistenteRepository.findAll();
    }

    @PostMapping
    public Asistente postNews(@RequestBody Asistente asistente) {

        asistenteRepository.save(asistente);

        return asistente;

    }

    @PutMapping("/{id}")
    public Asistente putClientebyId(@PathVariable Integer id, @RequestBody Asistente asistente) {

        Optional<Asistente> asistenteCurrent = asistenteRepository.findById(id);

        if (asistenteCurrent.isPresent()) {

            Asistente asistenteReturn = asistenteCurrent.get();

            asistenteReturn.setNombre(asistente.getNombre());
            asistenteReturn.setApellido(asistente.getApellido());
            asistenteReturn.setEmail(asistente.getInstitucion());
            asistenteReturn.setEmail(asistente.getEmail());
            asistenteReturn.setEmail(asistente.getCiudad());
            asistenteReturn.setEmail(asistente.getPais());
            asistenteReturn.setEmail(asistente.getTipo());
            asistenteReturn.setEmail(asistente.getPassword());

            asistenteRepository.save(asistenteReturn);

            return asistenteReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Asistente deleteNewsbyId(@PathVariable Integer id) {

        Optional<Asistente> asistente = asistenteRepository.findById(id);

        if (asistente.isPresent()) {

            Asistente asistenteReturn = asistente.get();

            asistenteRepository.deleteById(id);

            return asistenteReturn;
        }

        return null;

    }

    /*@GetMapping("cliente/{id}")
    public Long edadCuentaDelCliente(@PathVariable Integer id) {
        Optional<Asistente> elCliente = this.clienteServicio.buscar(id);
        long diasDeCuenta = this.clienteServicio.diasDeRegistro(elCliente.get());
        return diasDeCuenta;
    }*/
}
