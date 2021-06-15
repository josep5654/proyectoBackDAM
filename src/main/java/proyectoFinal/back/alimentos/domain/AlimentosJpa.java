package proyectoFinal.back.alimentos.domain;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.input.AlimentoInputDto;
import proyectoFinal.back.alimentos.infraestructure.controller.dto.output.AlimentoOutputDto;

import javax.persistence.*;


@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component
public class AlimentosJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_producto")
    private Integer id;

    @Column
    @NotNull
    private String nombre;

    @Column
    @NotNull
    private String tipoAlimento;

    @Column
    @NotNull
    private String marca;

    @Column
    @NotNull
    private String estado;



    @Column
    @NotNull

    private String categoria;

    @Column

    private String ingredientes;

    @Column
    @NotNull
    private String capacidad;

    @Column
    @NotNull
    private String tipoCapacidad;

    @Column
    @NotNull
    private Integer kcal;

    @Column
    private Double grasa;

    @Column
    @NotNull
    private Double saturadas;

    @Column
    @NotNull
    private Double hidratos;


    @Column
    @NotNull
    private Double azucares;

    @Column
    @NotNull
    private Double fibra;

    @Column
    @NotNull
    private Double proteinas;

    @Column
    @NotNull
    private Double sal;

   @Column
   private String imagen;








    public AlimentosJpa(AlimentoInputDto alimentoInputDto) {
        this.nombre = alimentoInputDto.getNombre();
        this.tipoAlimento=alimentoInputDto.getTipoAlimento();
        this.marca=alimentoInputDto.getMarca();
        this.estado = alimentoInputDto.getEstado();
        this.categoria = alimentoInputDto.getCategoria();
        this.ingredientes = alimentoInputDto.getIngredientes();
        this.capacidad = alimentoInputDto.getCapacidad();
        this.tipoCapacidad = alimentoInputDto.getTipoCapacidad();
        this.kcal = alimentoInputDto.getKcal();
        this.grasa = alimentoInputDto.getGrasa();
        this.saturadas = alimentoInputDto.getSaturadas();
        this.hidratos = alimentoInputDto.getHidratos();
        this.azucares = alimentoInputDto.getAzucares();
        this.fibra = alimentoInputDto.getFibra();
        this.proteinas = alimentoInputDto.getProteinas();
        this.sal = alimentoInputDto.getSal();
        this.imagen = alimentoInputDto.getImagen();
    }
    public AlimentosJpa(AlimentoOutputDto alimentoInputDto) {
        this.nombre = alimentoInputDto.getNombre();
        this.tipoAlimento=alimentoInputDto.getTipoAlimento();
        this.marca=alimentoInputDto.getMarca();
        this.estado = alimentoInputDto.getEstado();
        this.categoria = alimentoInputDto.getCategoria();
        this.ingredientes = alimentoInputDto.getIngredientes();
        this.capacidad = alimentoInputDto.getCapacidad();
        this.tipoCapacidad = alimentoInputDto.getTipoCapacidad();
        this.kcal = alimentoInputDto.getKcal();
        this.grasa = alimentoInputDto.getGrasa();
        this.saturadas = alimentoInputDto.getSaturadas();
        this.hidratos = alimentoInputDto.getHidratos();
        this.azucares = alimentoInputDto.getAzucares();
        this.fibra = alimentoInputDto.getFibra();
        this.proteinas = alimentoInputDto.getProteinas();
        this.sal = alimentoInputDto.getSal();
        this.imagen = alimentoInputDto.getImagen();
    }
}



