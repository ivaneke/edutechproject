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
import com.example.demo.service.IncidenciaService;
import com.example.demo.service.ResenaService;

@RestController
@RequestMapping("/Alumno")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

// Método para asignar un curso a un alumno

    @PostMapping("/{rut}/inscribir/{sigla}")
    public String alumnoAsignarCurso(@PathVariable String rut, @PathVariable String sigla) {
        return alumnoService.alumnoAsignarCurso(rut, sigla);
    }

// Método para crear una incidencia
    @Autowired
    private IncidenciaService incidenciaService;
    @PostMapping("/crearIncidencia")
    public String crearIncidencia(@RequestBody Incidencia incidencia) {
        return incidenciaService.crearIncidencia(incidencia);
    }
//Método para asignar una incidencia a un alumno por rut
    @PostMapping("/incidencias/{id}/asignar/{rut}")
    public String crearIncidenciaConAlumno(@PathVariable int id, @PathVariable String rut) {
        return incidenciaService.asignarIncidencia(id, rut);
    }
    

// Método para dejar una reseña
    @Autowired
    private ResenaService resenaService;
    @PostMapping("/dejarResena")
    public String dejarResena(@RequestBody Resena resena) {
        return resenaService.dejarResena(resena);
    }
}
