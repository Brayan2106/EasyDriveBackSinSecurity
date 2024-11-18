package pe.edu.upc.easydrive.servicesinterfaces;

import pe.edu.upc.easydrive.entities.Pagos;

import java.util.List;

public interface IPagosService {
    public List<Pagos> list();

    public void insert(Pagos pag);

    public Pagos listId(int id);

    public void delete(int id);

    public void update(Pagos pag);
}
