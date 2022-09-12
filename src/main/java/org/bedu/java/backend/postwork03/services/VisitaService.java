package org.bedu.java.backend.postwork03.services;


import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.postwork03.controllers.mappers.VisitaMapper;
import org.bedu.java.backend.postwork03.model.Visita;
import org.bedu.java.backend.postwork03.persistance.VisitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitaService {
    private final VisitaRepository repository;
    private final VisitaMapper mapper;

    public Visita guardaVisita(Visita visita) {
        return mapper.visitaDtoToVisita(
                repository.save(mapper.visitaToVisitaDto(visita))
        );
    }

    public List<Visita> obtenVisitas(){
        return repository.findAll().stream().map(visita -> mapper.visitaDtoToVisita(visita)).collect(Collectors.toList());
    }

    public Optional<Visita> obtenVisita(long idVisita) {
        return repository.findById(idVisita)
                .map(Visita -> Optional.of(mapper.visitaDtoToVisita(Visita)))
                .orElse(Optional.empty());
    }

    public void eliminaVisita(long idVisita){
        repository.deleteById(idVisita);
    }

    public Visita actualizaVisita(Visita visita){
        return mapper.visitaDtoToVisita(
                repository.save(mapper.visitaToVisitaDto(visita))
        );
    }

    public long cuenteVisitas(){
        return repository.count();
    }
}