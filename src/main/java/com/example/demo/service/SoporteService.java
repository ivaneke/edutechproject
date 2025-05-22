package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Incidencia;
import com.example.demo.repository.IncidenciaRepository;

@Service
public class SoporteService {
    @Autowired
    private IncidenciaRepository incidenciaRepository;

//Método para listar todas las incidencias

    public List<Incidencia> listarIncidencias() {
        return incidenciaRepository.findAll();
    }
}
