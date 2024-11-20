package unisangil.GestionPlus.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisangil.GestionPlus.modelo.Egreso;
import unisangil.GestionPlus.modelo.Totales;
import unisangil.GestionPlus.repositorio.EgresoRepositorio;

import java.util.List;

@Service
public class EgresoServicio implements IEgresoServicio {

    @Autowired
    private EgresoRepositorio egresoRepository;

    @Autowired
    private ITotalesServicio totalesServicio;

    @Override
    public List<Egreso> listarEgresos() {
        return egresoRepository.findAll();
    }

    @Override
    public Egreso buscarEgresoPorId(Long idEgreso) {
        return egresoRepository.findById(idEgreso).orElse(null);
    }

    @Override
    public void guardarEgreso(Egreso egreso) {
        egresoRepository.save(egreso); // Guarda el egreso en la base de datos

        // Actualiza los totales
        Totales totales = totalesServicio.obtenerTotales();
        totales.setTotalEgresos(totales.getTotalEgresos() + egreso.getMonto());
        totales.setTotalNeto(totales.getTotalIngresos() - totales.getTotalEgresos());
        totalesServicio.actualizarTotales(totales);
    }

    @Override
    public void eliminarEgreso(Egreso egreso) {
        egresoRepository.delete(egreso);
    }
}
