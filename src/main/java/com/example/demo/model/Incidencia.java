package com.example.demo.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descipcion;
    private Date fecha;
    private String estado;
    private String tipo;
    private String solucion;

// Soporte que atiende la incidencia
    @ManyToOne
    private Soporte soporte; 

//Alumno que reporta la incidencia
    @ManyToOne
    private Alumno alumno;

    public Incidencia() {
        this.id = 0;
        this.descipcion = "";
        this.fecha = Date.valueOf(java.time.LocalDate.now()); // Inicializa con la fecha actual
        this.estado = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") //para darle formato a la fecha
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Soporte getSoporte() {
        return soporte;
    }

    public void setSoporte(Soporte soporte) {
        this.soporte = soporte;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getSolucion() {
        return solucion;
    }
    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }
    
}
