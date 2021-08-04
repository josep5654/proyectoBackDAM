package com.josepablo.proyectoBack.alimentos.infraestructure.repository.portOservicio;

import com.josepablo.proyectoBack.alimentos.Exceptions.NotFoundException;
import com.josepablo.proyectoBack.alimentos.Exceptions.UpdateErrorException;
import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;
import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface UpdateEstudiantePort {

    public AlimentoOutputDto updateAlimento(@PathVariable int id, @RequestBody AlimentoInputDto alimentoInputDto) throws UpdateErrorException, NotFoundException;
}
