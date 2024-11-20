package unisangil.GestionPlus.servicio;

import unisangil.GestionPlus.modelo.Ingreso;
import java.util.List;

public interface IIngresoServicio {
    List<Ingreso> listarIngresos();

    Ingreso buscarIngresoPorId(Long idIngreso);

    void guardarIngreso(Ingreso ingreso);

    void eliminarIngreso(Ingreso ingreso);
}