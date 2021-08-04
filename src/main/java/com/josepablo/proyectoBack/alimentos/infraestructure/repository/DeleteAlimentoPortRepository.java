package com.josepablo.proyectoBack.alimentos.infraestructure.repository;

import com.josepablo.proyectoBack.alimentos.infraestructure.repository.jpa.AlimentoJpaRepository;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.portOservicio.DeleteEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class DeleteAlimentoPortRepository implements DeleteEstudiantePort {

    @Autowired
    AlimentoJpaRepository alimentoJpaRepository;

    @Override
    public void deleteEstudianteById(int id) {

        alimentoJpaRepository.deleteById(id);
    }
}
