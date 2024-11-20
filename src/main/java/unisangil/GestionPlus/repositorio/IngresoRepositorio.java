package unisangil.GestionPlus.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unisangil.GestionPlus.modelo.Ingreso;

@Repository
public interface IngresoRepositorio extends JpaRepository<Ingreso, Long> {

}
