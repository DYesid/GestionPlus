package unisangil.GestionPlus.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class Totales {
    @Id
    private Long id = 1L;

    private Double totalIngresos = 0.0;
    private Double totalEgresos = 0.0;
    private Double totalNeto = 0.0;
}