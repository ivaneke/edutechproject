package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comentario;
    private int calificacion;
    private Date fecha;
/*
    //Una reseña es escrita por un alumno
    // Relación muchos a uno entre Resena y Alumno
    // Cada reseña es escrita por un único alumno, pero un alumno puede escribir múltiples reseñas
    @ManyToOne
    @JoinColumn(name="alumno_rut")
    @JsonManagedReference("alumno-resenas")
    private Alumno alumno;

    //Una reseña se realiza en un curso
    // Relación muchos a uno entre Resena y Curso
    // Cada reseña pertenece a un único curso, pero un curso puede tener múltiples reseñas
    @ManyToOne
    private Curso curso;
*/
    // Constructor por defecto
    public Resena() {
        this.id = 0;
        this.comentario = "";
        this.calificacion = 0;
        this.fecha = Date.valueOf(java.time.LocalDate.now()); // Inicializa con la fecha actual
    }

    // Getters y Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    
}
