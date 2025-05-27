package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contenido;
import com.example.demo.model.Evaluacion;
import com.example.demo.service.ContenidoService;
import com.example.demo.service.EvaluacionService;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    //Método para crear contenido

    @Autowired
    private ContenidoService contenidoService;
    @PostMapping("/contenido")
    public String crearContenido(@RequestBody Contenido contenido) {
        return contenidoService.crearContenido(contenido);
    }
    //Método para listar contenido

    @GetMapping("/contenido")
    public List<Contenido> listarContenido() {
        return contenidoService.listarContenido();
    }
    
    //Método para crear evaluaciones
    @Autowired
    private EvaluacionService evaluacionService;
    @PostMapping("/evaluacion")
    public String crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return evaluacionService.crearEvaluacion(evaluacion);
    }
    //Método para listar evaluaciones
    
    @GetMapping("/evaluacion")
    public List<Evaluacion> listarEvaluacion() {
        return evaluacionService.listarEvaluacion();
    }

}
