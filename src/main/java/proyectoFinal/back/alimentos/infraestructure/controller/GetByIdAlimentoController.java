package proyectoFinal.back.alimentos.infraestructure.controller;


import com.google.common.primitives.Bytes;
import io.swagger.models.Path;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.FileSystemResource;
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
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.ArrayList;
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




