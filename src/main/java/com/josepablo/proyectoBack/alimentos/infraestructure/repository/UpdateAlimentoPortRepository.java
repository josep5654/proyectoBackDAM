package com.josepablo.proyectoBack.alimentos.infraestructure.repository;

import com.josepablo.proyectoBack.alimentos.Exceptions.NotFoundException;
import com.josepablo.proyectoBack.alimentos.Exceptions.UpdateErrorException;
import com.josepablo.proyectoBack.alimentos.domain.AlimentosJpa;
import com.josepablo.proyectoBack.alimentos.infraestructure.controller.CreateAlimentoController;
import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;
import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.jpa.AlimentoJpaRepository;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.portOservicio.CreateAlimentoPort;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.portOservicio.UpdateEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateAlimentoPortRepository implements UpdateEstudiantePort {

    @Autowired
    GetByIdAlimentoPortRepository getByIdAlimentoPortRepository;
    @Autowired
    AlimentoJpaRepository alimentoJpaRepository;

    @Override
    public AlimentoOutputDto updateAlimento(int id, AlimentoInputDto alimentoInputDto) throws UpdateErrorException, NotFoundException {
        AlimentosJpa alimentosJpa = getByIdAlimentoPortRepository.getAlimentobyId(id);

        alimentosJpa.update(alimentoInputDto);

        alimentoJpaRepository.save(alimentosJpa);

        return  new AlimentoOutputDto(alimentosJpa);

    }
}

