package unisangil.GestionPlus.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisangil.GestionPlus.modelo.Ingreso;
import unisangil.GestionPlus.modelo.Totales;
import unisangil.GestionPlus.repositorio.IngresoRepositorio;

import java.util.List;

@Service
public class IngresoServicio implements IIngresoServicio {

    @Autowired
    private IngresoRepositorio ingresoRepository;

    @Autowired
    private ITotalesServicio totalesServicio;

    @Override
    public List<Ingreso> listarIngresos() {
        return ingresoRepository.findAll();
    }

    @Override
    public Ingreso buscarIngresoPorId(Long idIngreso) {
        return ingresoRepository.findById(idIngreso).orElse(null);
    }

    @Override
    public void guardarIngreso(Ingreso ingreso) {
        ingresoRepository.save(ingreso); // Guarda el ingreso en la base de datos

        // Actualiza los totales
        Totales totales = totalesServicio.obtenerTotales();
        totales.setTotalIngresos(totales.getTotalIngresos() + ingreso.getMonto());
        totales.setTotalNeto(totales.getTotalIngresos() - totales.getTotalEgresos());
        totalesServicio.actualizarTotales(totales);
    }

    @Override
    public void eliminarIngreso(Ingreso ingreso) {
        ingresoRepository.delete(ingreso);
    }
}
