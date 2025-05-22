package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Alumno {
    @Id
    private String rut;
    private String mail;
    private String nombre;
    private String apellido;
    private String contrasena;


    @ManyToMany
    @JoinTable(
        name= "alumno_curso",
        joinColumns= @JoinColumn(name= "alumno_rut"),
        inverseJoinColumns= @JoinColumn(name= "curso_sigla")
    )
    
    @JsonBackReference
    private List<Curso> cursos;

//Alumno reporta incidencia
    @OneToMany(mappedBy="alumno")
    @JsonBackReference
    private List<Incidencia> incidencias;

//Alumno deja una reseña
    @OneToMany(mappedBy="alumno")
    @JsonBackReference
    private List<Resena> resenas;

    public Alumno() {
        this.rut = "";
        this.mail = "";
        this.nombre = "";
        this.apellido = "";
        this.contrasena = "";
    }


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(List<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }
    
    public List<Resena> getResenas() {
        return resenas;
    }
    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }
    
}
