package proyectoFinal.back.alimentos.infraestructure.repository.portOservicio;

import proyectoFinal.back.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;

import java.util.List;

public interface GetEstudiantePort {
    public List<AlimentoOutputDto> getAllEstudiante();
}
