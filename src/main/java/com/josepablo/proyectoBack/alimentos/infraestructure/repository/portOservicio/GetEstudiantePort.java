package com.josepablo.proyectoBack.alimentos.infraestructure.repository.portOservicio;


import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;

import java.util.List;

public interface GetEstudiantePort {
    public List<AlimentoOutputDto> getAllEstudiante();
}
