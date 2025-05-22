package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Alumno;
import com.example.demo.model.Curso;
import com.example.demo.model.Incidencia;
import com.example.demo.model.Resena;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.IncidenciaRepository;
import com.example.demo.repository.ResenaRepository;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    //Método para asignar un curso a un alumno

    public String alumnoAsignarCurso(String rut, String sigla) {
        // OBTENEMOS ALUMNO Y CURSO
        if(!cursoRepository.existsById(sigla)) {
            return "El curso ingresado no fue encontrado";
        }

        if(!alumnoRepository.existsById(rut)) {
            return "El alumno ingresado no fue encontrado";
        }

        Curso curso = cursoRepository.findById(sigla).get();
        Alumno alumno = alumnoRepository.findById(rut).get();

        if(alumno.getCursos().contains(curso)) {
            return "El alumno ya se encuentra inscrito en el curso";
        } else {
            alumno.getCursos().add(curso);
            alumnoRepository.save(alumno);
            return "Alumno inscrito al curso correctamente";
        }
    }
    @Autowired
    private IncidenciaRepository incidenciaRepository;

//Método para crear una incidencia

    public String crearIncidencia(Incidencia incidencia) {
        incidenciaRepository.save(incidencia);
        return "Incidencia creada correctamente";
    }

    @Autowired
    private ResenaRepository resenaRepository;

//Método para dejar una reseña

    public String dejarResena(Resena resena) {
        resenaRepository.save(resena);
        return "Reseña creada correctamente";
    }
}
