package proyectoFinal.back.alimentos.infraestructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proyectoFinal.back.alimentos.Exceptions.NotFoundException;
import proyectoFinal.back.alimentos.domain.AlimentosJpa;
import proyectoFinal.back.alimentos.infraestructure.repository.jpa.AlimentoJpaRepository;
import proyectoFinal.back.alimentos.infraestructure.repository.portOservicio.GetByIdEstudiantePort;

@Component
public class GetByIdAlimentoPortRepository implements GetByIdEstudiantePort {

    @Autowired
    AlimentoJpaRepository alimentoJpaRepository;


    @Override
    public AlimentosJpa getAlimentobyId(int id) throws NotFoundException {

        AlimentosJpa alimentosJpa = alimentoJpaRepository.findById(id).orElseThrow(() -> new NotFoundException("Alimento no encontrado."));


        return  alimentosJpa;
    }
}
