package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Incidencia;
import com.example.demo.service.SoporteService;

@RestController
@RequestMapping("/soporte")
public class SoporteController {
    @Autowired
    private SoporteService soporteService;
    
    //Método para listar incidencias
    
    @GetMapping("/incidencias")
    public List<Incidencia> listarIncidencias() {
        return soporteService.listarIncidencias();
    }
}
