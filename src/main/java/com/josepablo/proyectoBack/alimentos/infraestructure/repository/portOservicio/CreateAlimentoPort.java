package com.josepablo.proyectoBack.alimentos.infraestructure.repository.portOservicio;


import com.josepablo.proyectoBack.alimentos.Exceptions.NotFoundException;
import com.josepablo.proyectoBack.alimentos.domain.AlimentosJpa;
import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;

public interface CreateAlimentoPort {
    public AlimentosJpa createAlimento(AlimentoInputDto alimentoInputDto);
}
