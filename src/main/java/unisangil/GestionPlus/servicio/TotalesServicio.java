package unisangil.GestionPlus.servicio;

import unisangil.GestionPlus.modelo.Totales;
import unisangil.GestionPlus.repositorio.TotalesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalesServicio implements ITotalesServicio {

    @Autowired
    private TotalesRepositorio totalesRepository;

    @Override
    public Totales obtenerTotales() {
        return totalesRepository.findById(1L).orElse(new Totales());
    }

    @Override
    public void actualizarTotales(Double ingreso, Double egreso) {
        Totales totales = obtenerTotales();

        if (ingreso != null) {
            totales.setTotalIngresos(totales.getTotalIngresos() + ingreso);
        }

        if (egreso != null) {
            totales.setTotalEgresos(totales.getTotalEgresos() + egreso);
        }

        totales.setTotalNeto(totales.getTotalIngresos() - totales.getTotalEgresos());
        totalesRepository.save(totales);
    }
}