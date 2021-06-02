package proyectoFinal.back.alimentos.infraestructure.controller;




import io.swagger.models.Path;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import proyectoFinal.back.alimentos.Exceptions.NotFoundException;
import proyectoFinal.back.alimentos.domain.AlimentosJpa;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;
import proyectoFinal.back.alimentos.infraestructure.noDB.StorageService;
import proyectoFinal.back.alimentos.infraestructure.repository.GetByIdAlimentoPortRepository;


import org.springframework.core.io.Resource;

import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.io.IOException;




@RestController
@RequestMapping("/api/alimento")
@CrossOrigin("*")

public class GetByIdAlimentoController {


    @Autowired
    GetByIdAlimentoPortRepository getByIdAlimentoPortRepository;




    @GetMapping("{id}")
    public AlimentoOutputDto GetEstudiantebyId(@PathVariable int id) throws NotFoundException {


        return new AlimentoOutputDto(getByIdAlimentoPortRepository.getAlimentobyId(id));


    }

    @GetMapping("/imagenes/{id}")
    public ResponseEntity<Resource> GetImagenbyId(@PathVariable int id) throws NotFoundException, IOException {




        AlimentosJpa alimentosJpa = getByIdAlimentoPortRepository.getAlimentobyId(id);

        return null;
    }






}




