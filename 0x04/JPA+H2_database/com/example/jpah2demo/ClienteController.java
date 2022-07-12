package com.example.jpah2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
       clienteRepository.save(cliente);

       return ResponseEntity.ok(cliente);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        Optional<Cliente> cliente = clienteRepository.findById(idClient);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
        Optional<Cliente> cliente = clienteRepository.findById(idClient);

        if (cliente.isPresent()) {
            clienteRepository.delete(cliente.get());
        }
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente clienteBanco = optionalCliente.get();
            if(cliente.getNome() != null && !cliente.getNome().isEmpty()) clienteBanco.setNome(cliente.getNome());
            if(cliente.getEmail() != null && !cliente.getEmail().isEmpty()) clienteBanco.setEmail(cliente.getEmail());
            if(cliente.getIdade() != null) clienteBanco.setIdade(cliente.getIdade());
            clienteRepository.save(clienteBanco);
        }

    }
}
