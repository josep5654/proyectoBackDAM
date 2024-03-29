package com.josepablo.proyectoBack.alimentos.infraestructure.repository;

import com.josepablo.proyectoBack.alimentos.domain.AlimentosJpa;
import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.jpa.AlimentoJpaRepository;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.portOservicio.GetEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAlimentoPortRepository implements GetEstudiantePort {
    @Autowired
    AlimentoJpaRepository alimentoJpaRepository;

    @Override
    public List<AlimentoOutputDto> getAllEstudiante(){
        List<AlimentosJpa> alimentosJpas = alimentoJpaRepository.findAll();

        List<AlimentoOutputDto> alimentoOutputDtos = alimentosJpas.stream().map(
                AlimentoOutputDto::new).collect(Collectors.toList());
        return alimentoOutputDtos;
    }
}
