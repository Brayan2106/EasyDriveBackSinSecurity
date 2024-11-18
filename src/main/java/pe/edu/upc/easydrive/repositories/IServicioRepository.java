package pe.edu.upc.easydrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.easydrive.entities.Servicio;

import java.util.List;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio, Integer> {
    ///HUB: Buscar servicios por su nombre
    @Query("Select s from Servicio s where s.NombreServicio like %:nombre%")
    public List<Servicio> buscar(@Param("nombre") String nombre);
}
