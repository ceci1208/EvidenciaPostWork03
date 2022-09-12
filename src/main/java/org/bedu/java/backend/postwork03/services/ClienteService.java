package org.bedu.java.backend.postwork03.services;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bedu.java.backend.postwork03.controllers.mappers.ClienteMapper;
import org.bedu.java.backend.postwork03.model.Cliente;
import org.bedu.java.backend.postwork03.persistance.ClienteRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

//Annotation that provides 
@Service

//Lombok annotation that provides the constructor.
@RequiredArgsConstructor


public class ClienteService {
    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public Cliente guardaCliente(Cliente cliente) {
        return mapper.clienteDtoToCliente(
                repository.save(mapper.clienteToClienteDto(cliente))
        );
    }

    public List<Cliente> obtenClientes(){
        return repository.findAll().stream().map(cliente -> mapper.clienteDtoToCliente(cliente)).collect(Collectors.toList());
    }

    public Optional<Cliente> obtenCliente(long idCliente) {
        return repository.findById(idCliente)
                .map(cliente -> Optional.of(mapper.clienteDtoToCliente(cliente)))
                .orElse(Optional.empty());
    }

    public void eliminaCliente(long idcliente){
        repository.deleteById(idcliente);
    }

    public Cliente actualizaCliente(Cliente cliente, long clienteId){
        return mapper.clienteDtoToCliente(
                repository.save(mapper.clienteToClienteDto(cliente))
        );
    }

    public long cuenteClientes(){
        return repository.count();
    }
}