package pe.edu.upc.easydrive.servicesinterfaces;

import pe.edu.upc.easydrive.entities.Servicio;

import java.util.List;

public interface IServicioService {
    public List<Servicio> list();

    public void insert(Servicio ser);

    public Servicio listId(int id);

    public void delete(int id);

    public void update(Servicio ser);

    public List<Servicio> buscar(String nombre);
}