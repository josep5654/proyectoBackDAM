package com.josepablo.proyectoBack.alimentos.infraestructure.controller;



import com.josepablo.proyectoBack.alimentos.Exceptions.NotFoundException;
import com.josepablo.proyectoBack.alimentos.domain.AlimentosJpa;
import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.GetByIdAlimentoPortRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
    public HashMap<String ,String > GetImagenbyId(@PathVariable int id) throws NotFoundException, IOException {


        AlimentosJpa alimentosJpa = getByIdAlimentoPortRepository.getAlimentobyId(id);
        String imagen = alimentosJpa.getImagen();

        File file = new File("src/main/java/images/"+imagen);

        try
        {byte[]bytes= Files.readAllBytes(file.toPath());
            System.out.println(bytes);
        }catch (Exception e){
            imagen = "src/main/java/images/null.png";

             file = new File(imagen);
        }



        byte[] fileContent = FileUtils.readFileToByteArray(file);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);

        HashMap<String ,String > lista = new HashMap();
        lista.put("imagen",encodedString);


        final String regex = "\\.(.+)";


        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(imagen);

        String format = "";
        while (matcher.find()) {

            format = matcher.group(1);

        }
        lista.put("format",format);


        return lista;


    }


}




