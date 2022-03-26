package co.com.sofka.diceroller;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface DadoRepository extends ReactiveCrudRepository<Dado, String> {
    
}
