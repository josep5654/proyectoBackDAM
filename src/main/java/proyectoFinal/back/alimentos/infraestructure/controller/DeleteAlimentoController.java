package proyectoFinal.back.alimentos.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyectoFinal.back.alimentos.infraestructure.repository.DeleteEstudiantePortRepository;

@RestController
@RequestMapping("/api/alimento")
@CrossOrigin("*")
public class DeleteAlimentoController {
    @Autowired
    DeleteEstudiantePortRepository deleteEstudiantePortRepository;

    @DeleteMapping("{id}")
    public void DeleteEstudiante(@PathVariable int id) {
            deleteEstudiantePortRepository.deleteEstudianteById(id);
    }
}
