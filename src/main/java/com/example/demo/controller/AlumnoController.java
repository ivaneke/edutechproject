package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Incidencia;
import com.example.demo.model.Resena;
import com.example.demo.service.AlumnoService;

@RestController
@RequestMapping("/perfilAlumno")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

// Método para asignar un curso a un alumno

    @PostMapping("/{rut}/inscribir/{sigla}")
    public String alumnoAsignarCurso(@PathVariable String rut, @PathVariable String sigla) {
        return alumnoService.alumnoAsignarCurso(rut, sigla);
    }

// Método para crear una incidencia

    @PostMapping("/crearIncidencia")
    public String crearIncidencia(@RequestBody Incidencia incidencia) {
        return alumnoService.crearIncidencia(incidencia);
    }

// Método para dejar una reseña

    @PostMapping("/dejarResena")
    public String dejarResena(@RequestBody Resena resena) {
        return alumnoService.dejarResena(resena);
    }
}
