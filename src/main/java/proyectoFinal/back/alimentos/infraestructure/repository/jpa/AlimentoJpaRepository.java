package proyectoFinal.back.alimentos.infraestructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import proyectoFinal.back.alimentos.domain.AlimentosJpa;

import java.util.Date;
import java.util.List;

public interface AlimentoJpaRepository extends JpaRepository<AlimentosJpa,Integer> {
    /*
    @Query(value = "select E from AlimentosJpa E where nombre contains ':name'")
    List<AlimentosJpa> buscarAlimentoPorNombre(String name);
*/


    List<AlimentosJpa> findByNombre(String nombre);
}
