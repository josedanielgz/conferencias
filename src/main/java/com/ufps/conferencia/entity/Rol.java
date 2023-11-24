package com.ufps.conferencia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    @Enumerated(EnumType.STRING)
    private TipoRol tipo_Rol;
    
     public enum TipoRol {
        ADMINISTRADOR,
        CHAIR,
        PARTICIPANTE,
        USUARIO
        // Otros roles según sea necesario
    }*/
    @Column(name = "nombre")
    private String tipo_rol;
    

    @Override
    public String toString() {
        return "Rol{id=" + id + ", nombre='" + tipo_rol + "'}";
    }
}
