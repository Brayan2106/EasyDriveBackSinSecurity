package pe.edu.upc.easydrive.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.easydrive.entities.Notificaciones;
import pe.edu.upc.easydrive.repositories.INotificacionesRepository;
import pe.edu.upc.easydrive.servicesinterfaces.INotificacionesService;

import java.util.List;

@Service
public class NotificacionesServiceImplement implements INotificacionesService {
    @Autowired
    private INotificacionesRepository nS;


    @Override
    public List<Notificaciones> list() {
        return nS.findAll();
    }

    @Override
    public void insert(Notificaciones not) {
        nS.save(not);
    }

    @Override
    public Notificaciones listId(int id) {
        return nS.findById(id).orElse(new Notificaciones());
    }

    @Override
    public void delete(int id) {
        nS.deleteById(id);
    }

    @Override
    public void update(Notificaciones not) {
        nS.save(not);
    }

    @Override
    public List<Notificaciones> buscar(String nombre) {
        return nS.buscar(nombre);
    }

    @Override
    public List<String[]> numeronotificaciones() { return nS.numeronotificaciones();  }
}
