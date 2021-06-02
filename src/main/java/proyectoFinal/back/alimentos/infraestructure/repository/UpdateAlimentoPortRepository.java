package proyectoFinal.back.alimentos.infraestructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proyectoFinal.back.alimentos.Exceptions.UpdateErrorException;
import proyectoFinal.back.alimentos.domain.AlimentosJpa;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;
import proyectoFinal.back.alimentos.infraestructure.repository.jpa.AlimentoJpaRepository;
import proyectoFinal.back.alimentos.infraestructure.repository.portOservicio.UpdateEstudiantePort;

import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateAlimentoPortRepository implements UpdateEstudiantePort {

    @Autowired
    AlimentoJpaRepository alimentoJpaRepository;

    @Override
    public AlimentoOutputDto updateEstudiante(int id, AlimentoInputDto alimentoInputDto) throws UpdateErrorException {
        return alimentoJpaRepository.findById(id).map(alimentosJpa -> {

                    List<String> msgError = new ArrayList<>();
                    //TODO refactorizar (creo que ya)


                    if (msgError != null) {
                        try {
                            throw new UpdateErrorException("Campos que contienen errores");
                        } catch (UpdateErrorException e) {
                            e.printStackTrace();
                        }
                    }

                    alimentosJpa = new AlimentosJpa(alimentoInputDto);

                    alimentoJpaRepository.save(alimentosJpa);

                    AlimentoOutputDto alimentoOutputDto = new AlimentoOutputDto(alimentosJpa);
                    return alimentoOutputDto;

                }
        ).orElseThrow(() -> new UpdateErrorException("Error al actualizar un alimento."));
    }
}

