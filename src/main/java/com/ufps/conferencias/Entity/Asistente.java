package com.ufps.conferencias.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "asistente")
public class Asistente extends Usuario{



}
