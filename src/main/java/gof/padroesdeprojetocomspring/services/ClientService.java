package gof.padroesdeprojetocomspring.services;

import gof.padroesdeprojetocomspring.entities.Cliente;

public interface ClientService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
