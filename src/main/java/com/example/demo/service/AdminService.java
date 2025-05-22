package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AlumnoDTO;
import com.example.demo.model.Alumno;
import com.example.demo.model.GestorCursos;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.repository.GestorCursosRepository;

@Service
public class AdminService {
     @Autowired
    private AlumnoRepository alumnoRepository;
// Método para registrar un alumno
    public String registrarAlumno(Alumno alumno) {
        if (alumnoRepository.findById(alumno.getRut()).isPresent()) {
            return "El alumno con RUT " + alumno.getRut() + " ya existe.";
        }

        alumnoRepository.save(alumno);
        return "Alumno registrado exitosamente.";
    }
//Método para listar alumnos con respectivo DTO que oculta contraseña
// y devuelve solo los datos necesarios
    public List<AlumnoDTO> listarAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        return alumnos.stream()
                .map(alumno -> new AlumnoDTO(
                        alumno.getRut(),
                        alumno.getNombre(),
                        alumno.getApellido(),
                        alumno.getCursos()
                )).collect(Collectors.toList());
    }

// Método para crear un gestor de cursos
    @Autowired
    private GestorCursosRepository gestorCursosRepository;

    public String registrarGestorCursos(GestorCursos gestorCursos) {
        if (gestorCursosRepository.findById(gestorCursos.getId()).isPresent()) {
            return "El instructor ya existe";
        }
        gestorCursosRepository.save(gestorCursos);
        return "Instructor registrado correctamente";
    }
// Método para listar gestores de cursos
    public List<GestorCursos> listarGestoresCursos() {
        return gestorCursosRepository.findAll();
    }


}
