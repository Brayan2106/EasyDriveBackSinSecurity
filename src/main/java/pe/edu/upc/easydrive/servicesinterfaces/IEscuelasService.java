package pe.edu.upc.easydrive.servicesinterfaces;

import pe.edu.upc.easydrive.entities.Escuelas;

import java.util.List;

public interface IEscuelasService {
    public List<Escuelas> list();

    public void insert(Escuelas esc);

    public Escuelas listId(int id);

    public void delete(int id);

    public void update(Escuelas esc);

    public List<Escuelas> buscar(String nombre);

    public List<String[]> CalificacionPromedioPorEscuelas();
}
