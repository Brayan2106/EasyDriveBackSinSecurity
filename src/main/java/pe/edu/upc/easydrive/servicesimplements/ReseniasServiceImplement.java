package pe.edu.upc.easydrive.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.easydrive.entities.Resenias;
import pe.edu.upc.easydrive.repositories.IReseniasRepository;
import pe.edu.upc.easydrive.servicesinterfaces.IReseniasService;

import java.util.List;

@Service
public class ReseniasServiceImplement implements IReseniasService {
    @Autowired
    private IReseniasRepository rR;


    @Override
    public List<Resenias> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Resenias res) {
        rR.save(res);
    }

    @Override
    public Resenias listId(int id) {
        return rR.findById(id).orElse(new Resenias());
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public void update(Resenias res) {
        rR.save(res);
    }

    @Override
    public List<String[]> cantidadService() { return rR.cantidad(); }
}
