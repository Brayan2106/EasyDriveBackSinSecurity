package pe.edu.upc.easydrive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.easydrive.entities.Pagos;

@Repository
public interface IPagosRepository extends JpaRepository<Pagos, Integer> {
}
