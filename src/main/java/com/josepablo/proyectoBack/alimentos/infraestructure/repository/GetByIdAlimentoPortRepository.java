package com.josepablo.proyectoBack.alimentos.infraestructure.repository;

import com.josepablo.proyectoBack.alimentos.Exceptions.NotFoundException;
import com.josepablo.proyectoBack.alimentos.domain.AlimentosJpa;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.jpa.AlimentoJpaRepository;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.portOservicio.GetByIdEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GetByIdAlimentoPortRepository implements GetByIdEstudiantePort {

    @Autowired
    AlimentoJpaRepository alimentoJpaRepository;


    @Override
    public AlimentosJpa getAlimentobyId(int id) throws NotFoundException {

        AlimentosJpa alimentosJpa = alimentoJpaRepository.findById(id).orElseThrow(() -> new NotFoundException("Alimento no encontrado."));


        return  alimentosJpa;
    }
}
