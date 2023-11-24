/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufps.conferencia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Asistente extends Usuario {

    private String ciudad;
    private String pais;
    private String institucion;
    private String tipoIdentificacion;
    private String numeroIdentificacion;

    @ManyToMany(mappedBy = "asistentes")
    private List<Conferencia> conferencias;

    // Getters y setters
}

