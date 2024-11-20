package unisangil.GestionPlus.servicio;

import unisangil.GestionPlus.modelo.Egreso;
import unisangil.GestionPlus.repositorio.EgresoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EgresoServicio implements IEgresoServicio {

    @Autowired
    private EgresoRepositorio egresoRepository;

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
        egresoRepository.save(egreso);
    }

    @Override
    public void eliminarEgreso(Egreso egreso) {
        egresoRepository.delete(egreso);
    }
}