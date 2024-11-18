package pe.edu.upc.easydrive.servicesinterfaces;

import pe.edu.upc.easydrive.entities.Reservas;

import java.util.List;

public interface IReservasService {
    public List<Reservas> list();

    public void insert(Reservas res);

    public Reservas listId(int id);

    public void delete(int id);

    public void update(Reservas res);

    public List<String[]>sumaService();

    public List<String[]>cantidadService();

    public List<String[]> GananciasPorPromociones();

    public List<String[]> AnalisisServicios();

    public List<String[]> cantidadc();
}
