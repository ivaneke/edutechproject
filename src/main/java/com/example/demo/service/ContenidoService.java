package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contenido;
import com.example.demo.repository.ContenidoRepository;

@Service
public class ContenidoService {
    @Autowired
    private ContenidoRepository contenidoRepository;

    //Método para crear contenido
    
    public String crearContenido(Contenido contenido) {
        if (contenidoRepository.findByTitulo(contenido.getTitulo()).isPresent()) {
            return "El contenido ya existe";
        }
        contenidoRepository.save(contenido);
        return "Contenido creado correctamente";
    }
   
    //Método para listar contenido

    public List<Contenido> listarContenido() {
        return contenidoRepository.findAll();
    }
}
