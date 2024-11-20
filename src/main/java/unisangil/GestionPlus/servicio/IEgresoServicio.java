package unisangil.GestionPlus.servicio;

import unisangil.GestionPlus.modelo.Egreso;
import java.util.List;

public interface IEgresoServicio {
    List<Egreso> listarEgresos();

    void guardarEgreso(Egreso egreso);

}
