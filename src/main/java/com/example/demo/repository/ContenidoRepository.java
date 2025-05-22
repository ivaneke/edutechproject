package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Contenido;

public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {

}
