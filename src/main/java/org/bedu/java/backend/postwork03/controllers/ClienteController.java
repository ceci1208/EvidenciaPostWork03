package org.bedu.java.backend.postwork03.controllers;


import org.bedu.java.backend.postwork03.model.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.bedu.java.backend.postwork03.services.*;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;


//Annotation that indicates the url to make the CRUD operations.
@RequestMapping("/cliente")
//Annotation that indicates that the class will work as a Rest Controller.
@RestController
//Annotation that provides automatically all the constructors required. 
@RequiredArgsConstructor
public class ClienteController {
    
    //Calls the class ClienteService and allocate it in a variable called clienteService
    private final ClienteService clienteService;

    //Annotation that provides a Get method and indicates the url to the method.
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long clienteId) {

        Optional<Cliente> clienteDb = clienteService.obtenCliente(clienteId);

        if (clienteDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El cliente especificado no existe.");
        }

        return ResponseEntity.ok(clienteDb.get());
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getClientes() {
        return ResponseEntity.ok(clienteService.obtenClientes());
    }

    @PostMapping
    public ResponseEntity<Void> creaCliente(@Valid @RequestBody Cliente cliente) {
        Cliente clienteNuevo = clienteService.guardaCliente(cliente);

        return ResponseEntity.created(URI.create(String.valueOf(clienteNuevo.getId()))).build();
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Void> actualizaCliente(@PathVariable Long clienteId, @RequestBody @Valid Cliente cliente) {

        clienteService.eliminaCliente(clienteId);
        cliente.setId(clienteId);
        clienteService.actualizaCliente(cliente,clienteId);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> eliminaCliente(@PathVariable Long clienteId) {
        clienteService.eliminaCliente(clienteId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}