package pe.edu.upc.easydrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.easydrive.entities.Calendario;

@Repository
public interface ICalendarioRepository extends JpaRepository<Calendario, Integer> {
}
