package gof.padroesdeprojetocomspring.controllers;

import gof.padroesdeprojetocomspring.entities.Cliente;
import gof.padroesdeprojetocomspring.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.ok(clientService.buscarTodos());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(clientService.buscarPorId(id));
    }
}
