package com.josepablo.proyectoBack.alimentos.infraestructure.controller;

import com.josepablo.proyectoBack.alimentos.Exceptions.NotFoundException;
import com.josepablo.proyectoBack.alimentos.domain.AlimentosJpa;

import com.josepablo.proyectoBack.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.GetByIdAlimentoPortRepository;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.UpdateAlimentoPortRepository;
import com.josepablo.proyectoBack.alimentos.infraestructure.repository.portOservicio.CreateAlimentoPort;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/alimento")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class CreateAlimentoController {

  CreateAlimentoPort createEstudiantePort;
  GetByIdAlimentoPortRepository getByIdAlimentoPortRepository;
  UpdateAlimentoPortRepository updateAlimentoPortRepository;
  AlimentosJpa alimentosJpaGeneral;
  AlimentoInputDto alimentoInputDto;

  @PostMapping("/")
  public AlimentosJpa PostEstudiante(@RequestBody AlimentoInputDto alimentoInputDto)
      throws NotFoundException {
    System.out.println(("Entrada paso 8"));
    alimentosJpaGeneral = createEstudiantePort.createAlimento(alimentoInputDto);
    System.out.println(alimentosJpaGeneral.toString());
    System.out.println("impriendo jpagneral");
    System.out.println(alimentosJpaGeneral);
    return alimentosJpaGeneral;
  }

  @CrossOrigin("*")
  @PostMapping("/uploadImage/{userId}")
  public int saveAlimentoAndImage(
      @PathVariable int userId, @RequestParam("file") MultipartFile file, HttpSession session)
      throws NotFoundException, IOException {

    String nameExtension[] = file.getContentType().split("/");
    String profileImage = userId + "." + nameExtension[1];

    Path rootLocation = Paths.get("src/main/java/images/" + profileImage);
    Path rootLocation2 = Paths.get("src/main/java/images/");
    System.out.println(rootLocation);
    System.out.println("paso 4.9 --> " + rootLocation);
    byte[] bytes = file.getBytes();

    if (alimentosJpaGeneral.getId() > 0) {

      if (alimentosJpaGeneral.getImagen() == null
          || alimentosJpaGeneral.getImagen() == " "
          || alimentosJpaGeneral.getImagen() == "") {

        System.out.println("inside image Upload IF when getProfileImage() is null ");

        try {

          Files.write(rootLocation, bytes);

          alimentoInputDto.setImagen(profileImage);
          alimentosJpaGeneral.setImagen(profileImage);
          updateAlimentoPortRepository.updateAlimento(
              alimentosJpaGeneral.getId(), alimentoInputDto);

        } catch (Exception exception) {
          System.out.println("error while uploading image catch:: " + exception.getMessage());

          return -5;
        }
      } else {
        System.out.println("inside else ");
        try {

          Files.delete(rootLocation2.resolve(alimentosJpaGeneral.getImagen()));

          Files.write(rootLocation, bytes);

        } catch (Exception exception) {
          System.out.println(
              "Error while uploading image when image is already Exists :: "
                  + exception.getMessage());
        }
      }
    } else {
      return 0;
    }
    return userId;
  }
}
