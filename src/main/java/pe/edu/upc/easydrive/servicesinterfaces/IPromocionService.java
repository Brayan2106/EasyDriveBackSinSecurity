package pe.edu.upc.easydrive.servicesinterfaces;

import pe.edu.upc.easydrive.entities.Promocion;

import java.util.List;

public interface IPromocionService {
    public List<Promocion> list();

    public void insert(Promocion prom);

    public Promocion listId(int id);

    public void delete(int id);

    public void update(Promocion prom);

    public List<Promocion> buscar(String nombre);
}
