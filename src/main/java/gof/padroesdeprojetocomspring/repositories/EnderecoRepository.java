package gof.padroesdeprojetocomspring.repositories;

import gof.padroesdeprojetocomspring.entities.Cliente;
import gof.padroesdeprojetocomspring.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,String> {
}
