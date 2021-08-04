package com.josepablo.proyectoBack.alimentos.infraestructure.controller;

import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.GetAlimentoPortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/alimento")
@CrossOrigin("*")
public class GetAlimentoController {

    @Autowired
    GetAlimentoPortRepository getAlimentoPortRepository;

    @GetMapping("/all")
    public List<AlimentoOutputDto> GetEstudiantes() {

        return getAlimentoPortRepository.getAllEstudiante();


    }
}
