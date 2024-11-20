package unisangil.GestionPlus.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unisangil.GestionPlus.modelo.Egreso;

@Repository
public interface EgresoRepositorio extends JpaRepository<Egreso, Long> {

}
