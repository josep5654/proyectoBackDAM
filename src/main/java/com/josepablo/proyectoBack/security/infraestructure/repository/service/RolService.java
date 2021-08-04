package com.josepablo.proyectoBack.security.infraestructure.repository.service;


import com.josepablo.proyectoBack.security.domain.Rol;
import com.josepablo.proyectoBack.security.domain.enums.RolNombre;
import com.josepablo.proyectoBack.security.infraestructure.repository.jpa.RolRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
