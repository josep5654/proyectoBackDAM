package com.josepablo.proyectoBack.alimentos.infraestructure.controller;

import com.josepablo.proyectoBack.alimentos.infraestructure.repository.DeleteAlimentoPortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/alimento")
@CrossOrigin("*")

public class DeleteAlimentoController {
    @Autowired
    DeleteAlimentoPortRepository deleteAlimentoPortRepository;

    @DeleteMapping("{id}")
    public void DeleteEstudiante(@PathVariable int id) {

        deleteAlimentoPortRepository.deleteEstudianteById(id);
    }
}
