package unisangil.GestionPlus.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unisangil.GestionPlus.modelo.Totales;

@Repository
public interface TotalesRepositorio extends JpaRepository<Totales, Long> {

}
