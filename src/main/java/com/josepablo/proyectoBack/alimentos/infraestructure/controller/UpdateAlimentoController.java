package com.josepablo.proyectoBack.alimentos.infraestructure.controller;

import com.josepablo.proyectoBack.alimentos.Exceptions.UpdateErrorException;
import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;
import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.UpdateAlimentoPortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/alimento")
@CrossOrigin("*")
public class UpdateAlimentoController {
    @Autowired
    UpdateAlimentoPortRepository updateAlimentoPortRepository;

    @PutMapping("/{id}")
    public ResponseEntity<AlimentoOutputDto> PuAlimento(@PathVariable int id, @RequestBody AlimentoInputDto alimentoInputDto) throws UpdateErrorException {

        try{
            updateAlimentoPortRepository.updateAlimento(id, alimentoInputDto);
            return  ResponseEntity.accepted().build();
        } catch (Exception e){
            return ResponseEntity.status(404).build();
        }



    }

}
