package pe.edu.upc.easydrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.easydrive.entities.Notificaciones;

import java.util.List;

@Repository
public interface INotificacionesRepository extends JpaRepository<Notificaciones, Integer> {

    ///HUB: Buscar Notificaciones por el titulo
    @Query("Select n from Notificaciones n where n.Titulo like %:nombre%")
    public List<Notificaciones> buscar(@Param("nombre") String nombre);

    ///HUB: Calcular el total de notificaciones por usuario
    @Query(value = "SELECT u.username,count (n.idnotificacion) FROM users u\n" +
            "            join notificaciones n\n" +
            "            on u.id = n.idusuario\n" +
            "            group by u.username", nativeQuery = true)
    public List<String[]>numeronotificaciones();

}
