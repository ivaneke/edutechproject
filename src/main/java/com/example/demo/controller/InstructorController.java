package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Contenido;
import com.example.demo.service.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    //Método para crear contenido

    @PostMapping("/contenido")
    public String crearContenido(@RequestBody Contenido contenido) {
        return instructorService.crearContenido(contenido);
    }
    //Método para listar contenido

    @GetMapping("/contenido")
    public List<Contenido> listarContenido() {
        return instructorService.listarContenido();
    }
    
    //Método para crear evaluaciones

    @PostMapping("/evaluacion")
    public String crearEvaluacion(@RequestBody Contenido contenido) {
        return instructorService.crearEvaluacion(contenido);
    }
    //Método para listar evaluaciones
    
    @GetMapping("/evaluacion")
    public List<Contenido> listarEvaluacion() {
        return instructorService.listarEvaluacion();
    }

}
