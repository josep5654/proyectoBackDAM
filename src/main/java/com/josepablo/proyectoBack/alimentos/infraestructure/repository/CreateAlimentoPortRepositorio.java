package com.josepablo.proyectoBack.alimentos.infraestructure.repository;

import com.josepablo.proyectoBack.alimentos.Exceptions.NotFoundException;
import com.josepablo.proyectoBack.alimentos.domain.AlimentosJpa;
import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.jpa.AlimentoJpaRepository;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.portOservicio.CreateAlimentoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateAlimentoPortRepositorio implements CreateAlimentoPort {

  @Autowired AlimentoJpaRepository alimentoJpaRepository;

  @Override
  public AlimentosJpa createAlimento(AlimentoInputDto alimentoInputDto) {

    alimentoInputDto.comprobadorImagen(alimentoInputDto);

    AlimentosJpa alimentosJpa = new AlimentosJpa(alimentoInputDto);
    alimentoJpaRepository.save(alimentosJpa);

    return alimentosJpa;
  }
}
