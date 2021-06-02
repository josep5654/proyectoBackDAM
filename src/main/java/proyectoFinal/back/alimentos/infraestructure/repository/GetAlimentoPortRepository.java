package proyectoFinal.back.alimentos.infraestructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proyectoFinal.back.alimentos.domain.AlimentosJpa;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;
import proyectoFinal.back.alimentos.infraestructure.repository.jpa.AlimentoJpaRepository;
import proyectoFinal.back.alimentos.infraestructure.repository.portOservicio.GetEstudiantePort;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAlimentoPortRepository implements GetEstudiantePort {
    @Autowired
    AlimentoJpaRepository alimentoJpaRepository;

    @Override
    public List<AlimentoOutputDto> getAllEstudiante(){
        List<AlimentosJpa> alimentosJpas = alimentoJpaRepository.findAll();

        //alimentosJpa.getMarca();
        // TODO añadir marca
        //Todo refactorizar y agregar imagen
        List<AlimentoOutputDto> alimentoOutputDtos = alimentosJpas.stream().map(AlimentoOutputDto::new).collect(Collectors.toList());
        return alimentoOutputDtos;
    }
}
