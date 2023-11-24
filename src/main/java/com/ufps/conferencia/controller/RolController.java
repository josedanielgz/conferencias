/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.conferencia.controller;

import com.ufps.conferencia.entity.Rol;
import com.ufps.conferencia.entity.Usuario;
import com.ufps.conferencia.repository.RolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolController {
    
    
    @Autowired
    RolRepository rolRepository;
    
    @GetMapping("/roles")
    public List<Rol> getRolAll() {

        return rolRepository.findAll();
    }
}
