package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Registro_alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fechaInscripcion;
    private String estado; // Puede ser "pendiente", "aprobada", "rechazada"
/*
    //Registro se realiza por un alumno una única vez
    // Relación uno a uno entre Registro_alumno y Alumno
    // Cada registro pertenece a un único alumno y un alumno puede tener un único registro
    @OneToOne
    @JoinColumn(name = "alumno_rut")
    @JsonManagedReference("alumno-registro")
    private Alumno alumno; 

    //Registro aplica un cupón
    // Relación uno a muchos entre Registro_alumno y Cupón
    // Muchos registros pueden aplicar un único cupón, pero un cupón puede ser aplicado en múltiples registros
    @ManyToOne
    private Cupon cupon;
*/
    // Constructor por defecto
    public Registro_alumno() {
        this.fechaInscripcion = "";
        this.estado = "pendiente"; // Por defecto, la inscripción está pendiente
    }
    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  

    
 
    
}
