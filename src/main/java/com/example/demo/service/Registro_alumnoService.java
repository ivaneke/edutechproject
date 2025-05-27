package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Registro_alumno;
import com.example.demo.repository.Registro_alumnoRepository;

@Service
public class Registro_alumnoService {
    @Autowired
    private Registro_alumnoRepository registro_alumnoRepository;
    //Crear un registro de alumno
    public String crearRegistro(Registro_alumno registro) {
        if (registro_alumnoRepository.findById(registro.getId()).isPresent()) {
            return "El registro con ID " + registro.getId() + " ya existe.";
        }
        registro_alumnoRepository.save(registro);
        return "Registro de alumno creado exitosamente.";
    }

    //Aprobar un registro de alumno
    public String aprobarRegistro(int id) {
        if (registro_alumnoRepository.findById(id).isPresent()) {
            Registro_alumno registro = registro_alumnoRepository.findById(id).get();
            registro.setEstado("aprobado");
            registro_alumnoRepository.save(registro);
            return "Registro de alumno con ID " + id + " aprobado exitosamente.";
        } else {
            return "El registro con ID " + id + " no existe.";
        }
    }
    //Rechazar un registro de alumno
    public String rechazarRegistro(int id) {
        if (registro_alumnoRepository.findById(id).isPresent()) {
            Registro_alumno registro = registro_alumnoRepository.findById(id).get();
            registro.setEstado("rechazada");
            registro_alumnoRepository.save(registro);
            return "Registro de alumno con ID " + id + " rechazado exitosamente.";
        } else {
            return "El registro con ID " + id + " no existe.";
        }
    }

    //Obtener un registro de alumno por ID
    public Registro_alumno obtenerRegistroPorId(int id) {
        return registro_alumnoRepository.findById(id).orElse(null);
    }

}
