package unisangil.GestionPlus.servicio;

import unisangil.GestionPlus.modelo.Totales;

public interface ITotalesServicio {
    Totales obtenerTotales();

    void actualizarTotales(Totales totales);
}
