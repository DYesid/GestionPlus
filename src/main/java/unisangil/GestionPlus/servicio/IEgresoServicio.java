package unisangil.GestionPlus.servicio;

import unisangil.GestionPlus.modelo.Egreso;
import java.util.List;

public interface IEgresoServicio {
    List<Egreso> listarEgresos();

    Egreso buscarEgresoPorId(Long idEgreso);

    void guardarEgreso(Egreso egreso);

    void eliminarEgreso(Egreso egreso);
}
