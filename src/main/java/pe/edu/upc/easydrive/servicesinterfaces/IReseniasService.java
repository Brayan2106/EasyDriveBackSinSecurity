package pe.edu.upc.easydrive.servicesinterfaces;

import pe.edu.upc.easydrive.entities.Resenias;

import java.util.List;

public interface IReseniasService {
    public List<Resenias> list();

    public void insert(Resenias res);

    public Resenias listId(int id);

    public void delete(int id);

    public void update(Resenias res);

    public List<String[]> cantidadService();
}
