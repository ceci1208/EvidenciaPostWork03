package org.bedu.java.backend.postwork03.controllers.mappers;

import org.bedu.java.backend.postwork03.model.Visita;
import org.bedu.java.backend.postwork03.persistance.entities.VisitaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaDtoToVisita(VisitaDto visitaDto);

    VisitaDto visitaToVisitaDto(Visita visita);
}
