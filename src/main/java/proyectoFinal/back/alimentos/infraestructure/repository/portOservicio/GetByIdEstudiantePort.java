package proyectoFinal.back.alimentos.infraestructure.repository.portOservicio;

import proyectoFinal.back.alimentos.domain.AlimentosJpa;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;

public interface GetByIdEstudiantePort {
    public AlimentosJpa getAlimentobyId(int id) throws Exception;
}
