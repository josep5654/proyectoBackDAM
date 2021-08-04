package com.josepablo.proyectoBack.alimentos.infraestructure.repository.portOservicio;


import com.josepablo.proyectoBack.alimentos.domain.AlimentosJpa;

public interface GetByIdEstudiantePort {
    public AlimentosJpa getAlimentobyId(int id) throws Exception;
}
