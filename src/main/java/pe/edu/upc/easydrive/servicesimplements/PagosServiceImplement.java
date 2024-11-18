package pe.edu.upc.easydrive.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.easydrive.entities.Pagos;
import pe.edu.upc.easydrive.repositories.IPagosRepository;
import pe.edu.upc.easydrive.servicesinterfaces.IPagosService;

import java.util.List;

@Service
public class PagosServiceImplement implements IPagosService {
    @Autowired
    private IPagosRepository pR;


    @Override
    public List<Pagos> list() {
        return pR.findAll();
    }

    @Override
    public void insert(Pagos pag) {
        pR.save(pag);
    }

    @Override
    public Pagos listId(int id) {
        return pR.findById(id).orElse(new Pagos());
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public void update(Pagos pag) {
        pR.save(pag);
    }
}
