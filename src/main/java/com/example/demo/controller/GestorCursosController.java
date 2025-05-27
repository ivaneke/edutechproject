package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CursoDTO;
import com.example.demo.dto.InstructorDTO;
import com.example.demo.model.Curso;
import com.example.demo.model.Instructor;
import com.example.demo.service.CursoService;
import com.example.demo.service.InstructorService;

@RestController
@RequestMapping("/gestorCursos")
public class GestorCursosController {

//Método para almacenar un instructor
    @Autowired
    private InstructorService instructorService;
    @PostMapping("/instructores")
    public String almacenarInstructor(@RequestBody Instructor instructor) {
        return instructorService.registrarInstructor(instructor);
    }
    // Método para asignar un instructor a un curso
    @PostMapping("/{rut}/asignar/{sigla}")
    public String instructorAsignarCurso(@PathVariable String rut, @PathVariable String sigla) {
        return instructorService.instructorAsignarCurso(rut, sigla);
    }

    // Método para listar instructores

    @GetMapping("/instructores")
    public List<InstructorDTO> listarInstructores() {
        return instructorService.listarInstructores();
    }


    // Método para almacenar un curso
    @Autowired
    private CursoService cursoService;
    @PostMapping("/cursos")
    public String almacenarCurso(@RequestBody Curso curso) {
        return cursoService.registrarCurso(curso);
    }
// Método para listar cursos

    @GetMapping("/cursos")
    public List<CursoDTO> listarCursos() {
        return cursoService.listarCursos();
    }

// Método para listar curso por sigla
    @GetMapping("/cursos/{sigla}")
    public CursoDTO listarCursoPorSigla(String sigla) {
        return cursoService.listarCursoPorSigla(sigla);
    }
//Método para actualizar un curso por Sigla
    @PostMapping("/cursos/actualizar/{sigla}")
    public String actualizarCurso(@RequestBody Curso curso, String sigla) {
        return cursoService.actualizarCurso(curso, sigla);
    }


}
