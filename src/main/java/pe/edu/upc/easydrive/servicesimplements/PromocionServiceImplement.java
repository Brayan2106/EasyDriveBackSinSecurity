package pe.edu.upc.easydrive.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.easydrive.entities.Promocion;
import pe.edu.upc.easydrive.repositories.IPromocionRepository;
import pe.edu.upc.easydrive.servicesinterfaces.IPromocionService;

import java.util.List;

@Service
public class PromocionServiceImplement implements IPromocionService {
    @Autowired
    private IPromocionRepository pR;

    @Override
    public List<Promocion> list() {
        return pR.findAll();
    }

    @Override
    public void insert(Promocion prom) {
        pR.save(prom);
    }

    @Override
    public Promocion listId(int id) {
        return pR.findById(id).orElse(new Promocion());
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public void update(Promocion prom) {
        pR.save(prom);
    }

    @Override
    public List<Promocion> buscar(String nombre) {
        return pR.buscar(nombre);
    }
}
