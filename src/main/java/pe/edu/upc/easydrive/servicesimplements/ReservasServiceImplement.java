package pe.edu.upc.easydrive.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.easydrive.entities.Reservas;
import pe.edu.upc.easydrive.repositories.IReservasRepository;
import pe.edu.upc.easydrive.servicesinterfaces.IReservasService;

import java.util.List;

@Service
public class ReservasServiceImplement implements IReservasService {
    @Autowired
    private IReservasRepository rR;


    @Override
    public List<Reservas> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Reservas res) {rR.save(res);}

    @Override
    public Reservas listId(int id) {
        return rR.findById(id).orElse(new Reservas());
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public void update(Reservas res) {
        rR.save(res);
    }

    @Override
    public List<String[]> sumaService() {
        return rR.suma();
    }

    @Override
    public List<String[]> cantidadService() {
        return rR.cantidad();
    }

    @Override
    public List<String[]> GananciasPorPromociones() {
        return rR.GananciasPorPromociones();
    }

    @Override
    public List<String[]> AnalisisServicios() {
        return rR.AnalisisServicios();
    }

    @Override
    public List<String[]> cantidadc() {  return rR.cantidadc();  }
}
