package unisangil.GestionPlus.servicio;

import unisangil.GestionPlus.modelo.Ingreso;
import unisangil.GestionPlus.repositorio.IngresoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngresoServicio implements IIngresoServicio {

    @Autowired
    private IngresoRepositorio ingresoRepository;

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
        ingresoRepository.save(ingreso);
    }

    @Override
    public void eliminarIngreso(Ingreso ingreso) {
        ingresoRepository.delete(ingreso);
    }
}
