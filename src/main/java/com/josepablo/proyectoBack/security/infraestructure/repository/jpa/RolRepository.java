package com.josepablo.proyectoBack.security.infraestructure.repository.jpa;


import com.josepablo.proyectoBack.security.domain.Rol;

import com.josepablo.proyectoBack.security.domain.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
