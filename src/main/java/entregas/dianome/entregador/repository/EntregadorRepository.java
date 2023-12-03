package entregas.dianome.entregador.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import entregas.dianome.entregador.domain.Entregador;


public interface EntregadorRepository extends JpaRepository<Entregador, Integer> {
    
}
