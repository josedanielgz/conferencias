/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.conferencia.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Conferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fecha;

    
    @OneToOne(mappedBy = "conferencia")
    @JsonManagedReference
    private Chair chair;

    @ManyToMany
    @JoinTable(
            name = "usuario_conferencia",
            joinColumns = @JoinColumn(name = "conferencia_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Asistente> asistentes;

    // Otros campos y métodos
}
