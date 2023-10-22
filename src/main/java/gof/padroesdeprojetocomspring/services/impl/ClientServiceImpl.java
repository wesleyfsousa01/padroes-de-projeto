package gof.padroesdeprojetocomspring.services.impl;

import gof.padroesdeprojetocomspring.entities.Cliente;
import gof.padroesdeprojetocomspring.entities.Endereco;
import gof.padroesdeprojetocomspring.repositories.ClienteRepository;
import gof.padroesdeprojetocomspring.repositories.EnderecoRepository;
import gof.padroesdeprojetocomspring.services.ClientService;
import gof.padroesdeprojetocomspring.services.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        inserirComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        cliente = clienteRepository.getReferenceById(id);
        inserirComCep(cliente);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void inserirComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() ->{
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
