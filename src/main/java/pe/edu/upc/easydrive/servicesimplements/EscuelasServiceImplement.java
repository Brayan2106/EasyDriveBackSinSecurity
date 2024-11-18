package pe.edu.upc.easydrive.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.easydrive.entities.Escuelas;
import pe.edu.upc.easydrive.repositories.IEscuelasRepository;
import pe.edu.upc.easydrive.servicesinterfaces.IEscuelasService;

import java.util.List;

@Service
public class EscuelasServiceImplement implements IEscuelasService {
    @Autowired
    private IEscuelasRepository eR;

    @Override
    public List<Escuelas> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Escuelas esc) {
        eR.save(esc);
    }

    @Override
    public Escuelas listId(int id) {
        return eR.findById(id).orElse(new Escuelas());
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }

    @Override
    public void update(Escuelas esc) {
        eR.save(esc);
    }

    @Override
    public List<Escuelas> buscar(String nombre) {
        return eR.buscar(nombre);
    }

    @Override
    public List<String[]> CalificacionPromedioPorEscuelas() {
        return eR.CalificacionPromedioPorEscuelas();
    }
}
