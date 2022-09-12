package org.bedu.java.backend.postwork03.controllers.mappers;

import org.bedu.java.backend.postwork03.model.Etapa;
import org.bedu.java.backend.postwork03.persistance.entities.EtapaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface EtapaMapper {
    Etapa etapaDtoToEtapa(EtapaDto etapaDto);

    EtapaDto etapaToEtapaDto(Etapa etapa);
}
