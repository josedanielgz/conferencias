/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.conferencia.controller;

import com.ufps.conferencia.entity.Usuario;
import com.ufps.conferencia.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarioAll() {

        return usuarioRepository.findAll();
    }
    


    @PostMapping
    public Usuario postUsuario(@RequestBody Usuario usuario) {

        usuarioRepository.save(usuario);

        return usuario;

    }

    @PutMapping("/{id}")
    public Usuario putUsuariobyId(@PathVariable Long id, @RequestBody Usuario usuario) {

        Optional<Usuario> usuarioCurrent = usuarioRepository.findById(id);

        if (usuarioCurrent.isPresent()) {

            Usuario usuarioReturn = usuarioCurrent.get();

            usuarioReturn.setNombre(usuario.getNombre());
            usuarioReturn.setApellido(usuario.getApellido());
            usuarioReturn.setEmail(usuario.getEmail());
            usuarioReturn.setEmail(usuario.getPassword());

            usuarioRepository.save(usuarioReturn);

            return usuarioReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Usuario deleteNewsbyId(@PathVariable Long id) {

        Optional<Usuario> asistente = usuarioRepository.findById(id);

        if (asistente.isPresent()) {

            Usuario asistenteReturn = asistente.get();

            usuarioRepository.deleteById(id);

            return asistenteReturn;
        }

        return null;

    }

}
