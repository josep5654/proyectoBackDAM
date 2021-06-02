package proyectoFinal.back.alimentos.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;
import proyectoFinal.back.alimentos.infraestructure.repository.GetAlimentoPortRepository;

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
