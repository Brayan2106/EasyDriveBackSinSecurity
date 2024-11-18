package pe.edu.upc.easydrive.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.easydrive.entities.CentrosMedicos;
import pe.edu.upc.easydrive.repositories.ICentrosMedicosRepository;
import pe.edu.upc.easydrive.servicesinterfaces.ICentrosMedicosService;

import java.util.List;

@Service
public class CentrosMedicosServiceImplement implements ICentrosMedicosService {
    @Autowired
    private ICentrosMedicosRepository cR;

    @Override
    public List<CentrosMedicos> list() {
        return cR.findAll();
    }

    @Override
    public void insert(CentrosMedicos cen) {
        cR.save(cen);
    }

    @Override
    public CentrosMedicos listId(int id) {
        return cR.findById(id).orElse(new CentrosMedicos());
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public void update(CentrosMedicos cen) {
        cR.save(cen);
    }

    @Override
    public List<CentrosMedicos> buscar(String nombre) {
        return cR.buscar(nombre);
    }

    @Override
    public List<String[]> promedioreseniacentros() {
        return cR.promedioreseniacentros();
    }
}
