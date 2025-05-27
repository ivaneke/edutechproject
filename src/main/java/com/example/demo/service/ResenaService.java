package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Resena;
import com.example.demo.repository.ResenaRepository;

@Service
public class ResenaService {
    @Autowired
    private ResenaRepository resenaRepository;

//Método para dejar una reseña

    public String dejarResena(Resena resena) {
        resenaRepository.save(resena);
        return "Reseña creada correctamente";
    }

    
}
