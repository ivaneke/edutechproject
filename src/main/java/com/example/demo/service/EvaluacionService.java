package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Evaluacion;
import com.example.demo.repository.EvaluacionRepository;

@Service
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository evaluacionRepository;
    
    //Método para crear evaluación

    public String crearEvaluacion(Evaluacion evaluacion) {
        if (evaluacionRepository.findById(evaluacion.getId()).isPresent()) {
            return "La evaluacion ya existe";
        }
        evaluacionRepository.save(evaluacion);
        return "Evaluacion creada correctamente";
    }
    
//Método para listar evaluación

    public List<Evaluacion> listarEvaluacion() {
        return evaluacionRepository.findAll();
    }
}
