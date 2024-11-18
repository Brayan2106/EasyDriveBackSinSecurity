package pe.edu.upc.easydrive.servicesinterfaces;

import pe.edu.upc.easydrive.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role rol);

    public List<Role> list();

    public void delete(Long idRol);

    public Role listarId(Long idRol);
}
