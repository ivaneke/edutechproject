package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Alumno;
import com.example.demo.model.GestorCursos;
import com.example.demo.dto.AlumnoDTO;
import com.example.demo.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

// Método para registrar un nuevo alumno

    @PostMapping("/alumnos")
    public String almacenar(@RequestBody Alumno alumno) {
        return adminService.registrarAlumno(alumno);
    }

// Método para listar todos los alumnos

    @GetMapping("/alumnos")
    public List<AlumnoDTO> listarAlumnos() {
        return adminService.listarAlumnos();
    }

// Método para registrar un nuevo Gestor de Cursos

    @PostMapping("/gestores")
    public String almacenarGestorCursos(@RequestBody GestorCursos gestorCursos) {
        return adminService.registrarGestorCursos(gestorCursos);
    }

// Método para listar todos los Gestores de Cursos

    @GetMapping("/gestores")
    public List<GestorCursos> listargGestoresCursos() {
        return adminService.listarGestoresCursos();
    }
}
