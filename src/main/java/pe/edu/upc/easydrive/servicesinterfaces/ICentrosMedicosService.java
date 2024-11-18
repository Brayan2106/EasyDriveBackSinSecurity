package pe.edu.upc.easydrive.servicesinterfaces;

import pe.edu.upc.easydrive.entities.CentrosMedicos;

import java.util.List;

public interface ICentrosMedicosService {
    public List<CentrosMedicos> list();
    public void insert(CentrosMedicos cen);
    public CentrosMedicos listId(int id);
    public void delete(int id);
    public void update(CentrosMedicos cen);
    public List<CentrosMedicos>buscar(String nombre);
    public List<String[]> promedioreseniacentros();

}
