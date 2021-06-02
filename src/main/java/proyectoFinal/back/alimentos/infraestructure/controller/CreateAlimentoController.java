package proyectoFinal.back.alimentos.infraestructure.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import proyectoFinal.back.alimentos.Exceptions.NotFoundException;
import proyectoFinal.back.alimentos.domain.AlimentosJpa;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;
import proyectoFinal.back.alimentos.infraestructure.repository.CreateAlimentoPortRepositorio;
import proyectoFinal.back.alimentos.infraestructure.repository.GetByIdAlimentoPortRepository;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/alimento")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class CreateAlimentoController {

    CreateAlimentoPortRepositorio createEstudiantePortRepositorio;
    GetByIdAlimentoPortRepository getByIdAlimentoPortRepository;


    @PostMapping("/")
    public AlimentosJpa PostEstudiante(@RequestBody AlimentoInputDto alimentoInputDto) throws NotFoundException {

       AlimentosJpa alimentosJpaGeneral = createEstudiantePortRepositorio.createAlimento(alimentoInputDto);
            return alimentosJpaGeneral;



    }



    @CrossOrigin("*")
    @PostMapping("/uploadImage/{userId}")
    public int handleFileUpload(@PathVariable int userId , @RequestParam("file") MultipartFile file, HttpSession session) throws NotFoundException, IOException {

        AlimentosJpa alimentosJpaGeneral = getByIdAlimentoPortRepository.getAlimentobyId(userId);

        System.out.println(alimentosJpaGeneral.toString());

        String nameExtension[] = file.getContentType().split("/");
        String profileImage = userId + "." + nameExtension[1];


        Path rootLocation = Paths.get("src/main/java/images/"+profileImage);
        Path rootLocation2 = Paths.get("src/main/java/images/");
        System.out.println(rootLocation);
        System.out.println("paso 4.9 --> "+rootLocation);
        byte[] bytes = file.getBytes();

        if (alimentosJpaGeneral.getId() > 0) {

            if (alimentosJpaGeneral.getImagen() == null || alimentosJpaGeneral.getImagen() == " " || alimentosJpaGeneral.getImagen() == "") {

                System.out.println("paso 5");
                System.out.println("inside image Upload IF when getProfileImage() is null ");



                try {

                    Files.write(rootLocation,bytes);
                    System.out.println("--------------------------------------------------------");
                    alimentosJpaGeneral.setImagen(profileImage);
                    System.out.println(alimentosJpaGeneral.toString());
                    AlimentoInputDto alimentoInputDto = new AlimentoInputDto(alimentosJpaGeneral);
                    createEstudiantePortRepositorio.createAlimento(alimentoInputDto);
                } catch (Exception exception) {
                    System.out.println("error while uploading image catch:: " + exception.getMessage());

                    return -5;
                }
            } else {
                System.out.println("inside else ");
                try {

                    Files.delete(rootLocation2.resolve(alimentosJpaGeneral.getImagen()));

                    Files.write(rootLocation,bytes);

                } catch (Exception exception) {
                    System.out.println("Error while uploading image when image is already Exists :: " + exception.getMessage());

                }
            }
        } else {
            return 0;
        }
        return userId;
    }

}


