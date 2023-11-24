/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.conferencia.controller;

import com.ufps.conferencia.entity.Chair;
import com.ufps.conferencia.repository.ChairRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chair")
public class ChairController {
    
     @Autowired
     ChairRepository chairRepository;
     
     @GetMapping("/all")
    public List<Chair> getChairAll() {

        return chairRepository.findAll();
    }
}
