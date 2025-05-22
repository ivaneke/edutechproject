package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CursoDTO;
import com.example.demo.model.Curso;
import com.example.demo.model.Instructor;
import com.example.demo.service.GestorCursosService;

@RestController
@RequestMapping("/gestorCursos")
public class GestorCursosController {
    @Autowired
    private GestorCursosService gestorCursosService;

//Método para almacenar un instructor

    @PostMapping("/instructores")
    public String almacenarInstructor(@RequestBody Instructor instructor) {
        return gestorCursosService.registrarInstructor(instructor);
    }

    // Método para listar cursos

    @GetMapping("/instructores")
    public List<Instructor> listarInstructores() {
        return gestorCursosService.listarInstructores();
    }
// Método para almacenar un curso

    @PostMapping("/cursos")
    public String almacenarCurso(@RequestBody Curso curso) {
        return gestorCursosService.registrarCurso(curso);
    }
// Método para listar cursos

    @GetMapping("/cursos")
    public List<CursoDTO> listarCursos() {
        return gestorCursosService.listarCursos();
    }
}
