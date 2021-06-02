package proyectoFinal.back.alimentos.infraestructure.controller.dto.output;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import proyectoFinal.back.alimentos.domain.AlimentosJpa;



@Data
@AllArgsConstructor
public class AlimentoOutputDto {

    private int id;

    private String nombre;


    private String tipoAlimento;

    private String marca;
    private String estado;

    private String categoria;

    private String ingredientes;

    private String capacidad;

    private String tipoCapacidad;

    private Integer kcal;

    private Double grasa;

    private Double saturadas;

    private Double hidratos;

    private Double azucares;

    private Double fibra;

    private Double proteinas;

    private Double sal;

    private String imagen;

    public AlimentoOutputDto(AlimentosJpa alimentosJpa) {
        this.id = alimentosJpa.getId();
        this.nombre = alimentosJpa.getNombre();
        this.tipoAlimento = alimentosJpa.getTipoAlimento();
        this.marca = alimentosJpa.getMarca();
        this.estado = alimentosJpa.getEstado();
        this.categoria = alimentosJpa.getCategoria();
        this.ingredientes = alimentosJpa.getIngredientes();
        this.capacidad = alimentosJpa.getCapacidad();
        this.tipoCapacidad = alimentosJpa.getTipoCapacidad();
        this.kcal = alimentosJpa.getKcal();
        this.grasa = alimentosJpa.getGrasa();
        this.saturadas = alimentosJpa.getSaturadas();
        this.hidratos = alimentosJpa.getHidratos();
        this.azucares = alimentosJpa.getAzucares();
        this.fibra = alimentosJpa.getFibra();
        this.proteinas = alimentosJpa.getProteinas();
        this.sal = alimentosJpa.getSal();
        this.imagen = alimentosJpa.getImagen();


    }

}

