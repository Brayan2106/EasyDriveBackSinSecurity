package pe.edu.upc.easydrive.servicesinterfaces;

import pe.edu.upc.easydrive.entities.Calendario;

import java.util.List;

public interface ICalendarioService {
    public List<Calendario> list();

    public void insert(Calendario cal);

    public Calendario listId(int id);

    public void delete(int id);

    public void update(Calendario cal);
}
