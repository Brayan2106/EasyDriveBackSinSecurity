package pe.edu.upc.easydrive.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.easydrive.entities.Servicio;
import pe.edu.upc.easydrive.repositories.IServicioRepository;
import pe.edu.upc.easydrive.servicesinterfaces.IServicioService;

import java.util.List;


@Service
public class ServicioServiceImplement implements IServicioService {
    @Autowired
    private IServicioRepository sR;

    @Override
    public List<Servicio> list() {
        return sR.findAll();
    }

    @Override
    public void insert(Servicio ser) {
        sR.save(ser);
    }

    @Override
    public Servicio listId(int id) {
        return sR.findById(id).orElse(new Servicio());
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

    @Override
    public void update(Servicio ser) {
        sR.save(ser);
    }

    @Override
    public List<Servicio> buscar(String nombre) {
        return sR.buscar(nombre);
    }
}
