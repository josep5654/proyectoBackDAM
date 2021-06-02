package proyectoFinal.back.alimentos.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyectoFinal.back.alimentos.Exceptions.UpdateErrorException;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;
import proyectoFinal.back.alimentos.infraestructure.repository.UpdateAlimentoPortRepository;

@RestController
@RequestMapping("/api/alimento")
@CrossOrigin("*")
public class UpdateAlimentoController {
    @Autowired
    UpdateAlimentoPortRepository updateAlimentoPortRepository;

    @PutMapping("/{id}")
    public ResponseEntity<AlimentoOutputDto> PuAlimento(@PathVariable int id, @RequestBody AlimentoInputDto alimentoInputDto) throws UpdateErrorException {

        try{
            updateAlimentoPortRepository.updateEstudiante(id, alimentoInputDto);
            return  ResponseEntity.accepted().build();
        } catch (Exception e){
            return ResponseEntity.status(404).build();
        }



    }

}
