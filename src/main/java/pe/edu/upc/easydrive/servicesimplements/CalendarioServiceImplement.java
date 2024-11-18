package pe.edu.upc.easydrive.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.easydrive.entities.Calendario;
import pe.edu.upc.easydrive.repositories.ICalendarioRepository;
import pe.edu.upc.easydrive.servicesinterfaces.ICalendarioService;

import java.util.List;

@Service
public class CalendarioServiceImplement implements ICalendarioService {
    @Autowired
    private ICalendarioRepository cR;


    @Override
    public List<Calendario> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Calendario cal) {
        cR.save(cal);
    }

    @Override
    public Calendario listId(int id) {
        return cR.findById(id).orElse(new Calendario());
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public void update(Calendario cal) {
        cR.save(cal);
    }
}
