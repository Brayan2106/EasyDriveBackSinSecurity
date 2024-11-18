package pe.edu.upc.easydrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.easydrive.entities.Escuelas;

import java.util.List;

@Repository
public interface IEscuelasRepository extends JpaRepository<Escuelas, Integer> {
    ///HUB: Buscar Escuelas por nombre
    @Query("Select e from Escuelas e where e.nombre like %:nombre%")
    public List<Escuelas> buscar(@Param("nombre") String nombre);

    ///HUB: Calcular el promedio de reseñas por escuelas
    @Query(value = "SELECT e.nombre, AVG(r.calificacion) FROM escuelas e\n" +
            "JOIN resenias r\n" +
            "ON e.idescuela = r.idescuelas\n" +
            "GROUP BY e.nombre \n" +
            "ORDER BY AVG(r.calificacion) desc\n", nativeQuery = true)
    public List<String[]> CalificacionPromedioPorEscuelas();
}
