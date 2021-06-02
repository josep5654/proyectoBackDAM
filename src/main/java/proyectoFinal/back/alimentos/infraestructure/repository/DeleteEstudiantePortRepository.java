package proyectoFinal.back.alimentos.infraestructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import proyectoFinal.back.alimentos.infraestructure.repository.jpa.AlimentoJpaRepository;
import proyectoFinal.back.alimentos.infraestructure.repository.portOservicio.DeleteEstudiantePort;

@Component
public class DeleteEstudiantePortRepository  implements DeleteEstudiantePort {

    @Autowired
    AlimentoJpaRepository alimentoJpaRepository;

    @Override
    public void deleteEstudianteById(int id) {
        alimentoJpaRepository.deleteById(id);
    }
}
