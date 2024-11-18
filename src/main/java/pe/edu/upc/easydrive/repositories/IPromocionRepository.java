package pe.edu.upc.easydrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.easydrive.entities.Promocion;

import java.util.List;

@Repository
public interface IPromocionRepository extends JpaRepository<Promocion, Integer> {

    ///HUB: Buscar promociones por su nombre
    @Query("Select p from Promocion p where p.NombrePromocion like %:nombre%")
    public List<Promocion> buscar(@Param("nombre") String nombre);
}
