package pe.edu.upc.easydrive.servicesinterfaces;

import pe.edu.upc.easydrive.entities.Notificaciones;

import java.util.List;

public interface INotificacionesService {
    public List<Notificaciones> list();

    public void insert(Notificaciones not);

    public Notificaciones listId(int id);

    public void delete(int id);

    public void update(Notificaciones not);

    public List<Notificaciones> buscar(String nombre);

    public List<String[]>numeronotificaciones();

}
