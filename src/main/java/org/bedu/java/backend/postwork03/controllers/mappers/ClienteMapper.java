package org.bedu.java.backend.postwork03.controllers.mappers;

import org.bedu.java.backend.postwork03.model.Cliente;
import org.bedu.java.backend.postwork03.persistance.entities.ClienteDto;
import org.mapstruct.Mapper;

//Annotation that indicates the creation of a dto mapping.
@Mapper(componentModel = "spring")

public interface ClienteMapper {
    
    //Annotation that indicates the mapping from one class to another
    Cliente clienteDtoToCliente(ClienteDto clienteDto);

    ClienteDto clienteToClienteDto(Cliente cliente);
}
