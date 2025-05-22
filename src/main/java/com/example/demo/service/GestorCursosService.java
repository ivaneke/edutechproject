package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Alumno2DTO;
import com.example.demo.dto.CursoDTO;
import com.example.demo.model.Curso;
import com.example.demo.model.Instructor;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.InstructorRepository;

@Service
public class GestorCursosService {
    @Autowired
    private InstructorRepository instructorRepository;

// Método para registrar un instructor

    public String registrarInstructor(Instructor instructor) {
        if (instructorRepository.findById(instructor.getId()).isPresent()) {
            return "El instructor ya existe";
        }
        instructorRepository.save(instructor);
        return "Instructor registrado correctamente";
    }
    
    public List<Instructor> listarInstructores() {
        return instructorRepository.findAll();
    }

    @Autowired
    private CursoRepository cursoRepository;

// Método para registrar un curso

    public String registrarCurso(Curso curso) {
        if (cursoRepository.findById(curso.getSigla()).isPresent()) {
            return "El curso ya existe";
        }
        cursoRepository.save(curso);
        return "Curso registrado correctamente";
    }


//Método para listar cursos con DTO

    public List<CursoDTO> listarCursos() {
    List<Curso> cursos = cursoRepository.findAll();
    return cursos.stream()
            .map(curso -> new CursoDTO(
                    curso.getSigla(),
                    curso.getNombre(),
                    curso.getAlumnos().stream()
                        .map(alumno -> new Alumno2DTO(
                            alumno.getRut(),
                            alumno.getNombre(),
                            alumno.getApellido()
                        )).collect(Collectors.toList())
                        )).collect(Collectors.toList());
}

// Método para listar cursos por SIGLA

    public String eliminarCurso(String sigla) {
        if (cursoRepository.findById(sigla).isPresent()) {
            cursoRepository.deleteById(sigla);
            return "Curso eliminado correctamente";
        }
        return "El curso no existe";
    }
}
