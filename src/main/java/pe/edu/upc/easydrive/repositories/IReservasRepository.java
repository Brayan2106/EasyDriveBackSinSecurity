package pe.edu.upc.easydrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.easydrive.entities.Reservas;

import java.util.List;

@Repository
public interface IReservasRepository extends JpaRepository<Reservas, Integer> {


    ///Sumar las ganancias de servicios por escuelas
    @Query(value = "Select e.nombre , SUM(s.precio)\n" +
            "from servicio s\n" +
            "join reservas r\n" +
            "on s.idservicio = r.idservicio\n" +
            "join escuelas e \n" +
            "on e.idescuela = r.idescuela\n" +
            "Group by e.idescuela", nativeQuery = true)
    public List<String[]> suma();

    ///HUB: Contar la cantidad de reservas por escuelas
    @Query(value = "Select e.nombre, count(r.IDReserva)\n" +
            "from escuelas e\n" +
            "join reservas r\n" +
            "on e.IDEscuela = r.IDEscuela\n" +
            "group by e.nombre", nativeQuery = true)
    public List<String[]> cantidad();

    ///HUB: Contar la cantidad de reservas por centros medicos
    @Query(value = "Select c.nombre, count(r.IDReserva)\n" +
            "            from centros_medicos c\n" +
            "            join reservas r\n" +
            "            on c.idcentro = r.idcentro\n" +
            "            group by c.nombre", nativeQuery = true)
    public List<String[]> cantidadc();

    ///HUB: Calcular las ganancias de cada servicio por sus promociones
    @Query(value = "SELECT nombre_promocion , SUM(s.precio) from servicio s\n" +
            "JOIN reservas r\n" +
            "ON s.idservicio = r.idservicio\n" +
            "JOIN promocion p\n" +
            "ON p.idpromocion = r.idpromocion\n" +
            "GROUP BY p.idpromocion \n" +
            "ORDER BY SUM(s.precio) DESC", nativeQuery = true)
    public List<String[]> GananciasPorPromociones();

    ///HUB: Calcular ganancias por servicios y su cantidad
    @Query(value = "SELECT s.nombre_servicio , SUM(precio) , COUNT(s.idservicio) FROM servicio s\n" +
            "JOIN reservas r\n" +
            "ON s.idservicio = r.idservicio\n" +
            "GROUP BY s.idservicio\n" +
            "ORDER BY SUM(precio) desc;", nativeQuery = true)
    public List<String[]> AnalisisServicios();
}
