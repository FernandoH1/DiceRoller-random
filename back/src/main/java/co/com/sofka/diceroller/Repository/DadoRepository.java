package co.com.sofka.diceroller.Repository;

import co.com.sofka.diceroller.model.Dado;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DadoRepository extends ReactiveCrudRepository<Dado, String> {
    
}
