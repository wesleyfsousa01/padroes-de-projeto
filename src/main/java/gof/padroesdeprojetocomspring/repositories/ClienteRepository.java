package gof.padroesdeprojetocomspring.repositories;

import gof.padroesdeprojetocomspring.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
