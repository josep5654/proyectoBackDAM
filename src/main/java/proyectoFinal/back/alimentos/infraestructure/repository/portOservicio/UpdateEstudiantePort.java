package proyectoFinal.back.alimentos.infraestructure.repository.portOservicio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import proyectoFinal.back.alimentos.Exceptions.UpdateErrorException;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;

public interface UpdateEstudiantePort {

    public AlimentoOutputDto updateEstudiante(@PathVariable int id, @RequestBody AlimentoInputDto alimentoInputDto) throws UpdateErrorException;
}
