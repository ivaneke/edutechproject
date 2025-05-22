package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contenido;
import com.example.demo.repository.ContenidoRepository;

@Service
public class InstructorService {
    @Autowired
    private ContenidoRepository contenidoRepository;

//Método para crear contenido

    public String crearContenido(Contenido contenido) {
        if (contenidoRepository.findById(contenido.getId()).isPresent()) {
            return "El contenido ya existe";
        }
        contenidoRepository.save(contenido);
        return "Contenido creado correctamente";
    }

//Método para listar contenido

    public List<Contenido> listarContenido() {
        return contenidoRepository.findAll();
    }

//Método para crear evaluación

    public String crearEvaluacion(Contenido contenido) {
        if (contenidoRepository.findById(contenido.getId()).isPresent()) {
            return "La evaluacion ya existe";
        }
        contenidoRepository.save(contenido);
        return "Evaluacion creada correctamente";
    }
    
//Método para listar evaluación

    public List<Contenido> listarEvaluacion() {
        return contenidoRepository.findAll();
    }

}
