package unisangil.GestionPlus.servicio;

import unisangil.GestionPlus.modelo.Ingreso;
import java.util.List;

public interface IIngresoServicio {
    List<Ingreso> listarIngresos();

    void guardarIngreso(Ingreso ingreso);

}