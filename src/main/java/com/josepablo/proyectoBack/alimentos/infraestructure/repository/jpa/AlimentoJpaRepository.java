package com.josepablo.proyectoBack.alimentos.infraestructure.repository.jpa;


import com.josepablo.proyectoBack.alimentos.domain.AlimentosJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentoJpaRepository extends JpaRepository<AlimentosJpa,Integer> {



    List<AlimentosJpa> findByNombre(String nombre);
}
