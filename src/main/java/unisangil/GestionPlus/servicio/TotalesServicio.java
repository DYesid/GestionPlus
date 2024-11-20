package unisangil.GestionPlus.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unisangil.GestionPlus.modelo.Totales;
import unisangil.GestionPlus.repositorio.TotalesRepositorio;

@Service
public class TotalesServicio implements ITotalesServicio {

    @Autowired
    private TotalesRepositorio totalesRepository;

    @Override
    public Totales obtenerTotales() {
        return totalesRepository.findById(1L).orElse(new Totales());
    }

    @Override
    public void actualizarTotales(Totales totales) {
        totalesRepository.save(totales); // Guarda los totales actualizados
    }
}
