package proyectoFinal.back.alimentos.infraestructure.repository.portOservicio;

import proyectoFinal.back.alimentos.Exceptions.NotFoundException;
import proyectoFinal.back.alimentos.domain.AlimentosJpa;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;

public interface CreateAlimentoPort {
    public AlimentosJpa createAlimento(AlimentoInputDto alimentoInputDto) throws NotFoundException;
}
