package proyectoFinal.back.alimentos.infraestructure.repository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import proyectoFinal.back.alimentos.Exceptions.NotFoundException;
import proyectoFinal.back.alimentos.domain.AlimentosJpa;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;
import proyectoFinal.back.alimentos.infraestructure.repository.jpa.AlimentoJpaRepository;
import proyectoFinal.back.alimentos.infraestructure.repository.portOservicio.CreateAlimentoPort;

import java.util.List;

@Component
public class CreateAlimentoPortRepositorio implements CreateAlimentoPort {

    @Autowired
    AlimentoJpaRepository alimentoJpaRepository;


    @Override
    public AlimentosJpa createAlimento(AlimentoInputDto alimentoInputDto) throws NotFoundException {

        List<String>msgError = null;
/*

        List<String> msgError= alimentoInputDto.dtoInputComprobador(alimentoInputDto);
        List comprobadorFechas = alimentoInputDto.comprobadorContenido(alimentoInputDto);
*/
        alimentoInputDto.comprobadorImagen(alimentoInputDto);


        if (msgError !=null)
            return null;
        else {
         //   ImageModel imageModel= imageByIdRepository.imageID(alimentoInputDto.getImagen());
            AlimentosJpa alimentosJpa = new AlimentosJpa(alimentoInputDto);
         //   alimentosJpa.setImagen(imageModel);
            alimentoJpaRepository.save(alimentosJpa);

            return  alimentosJpa;
        }
    }
}
