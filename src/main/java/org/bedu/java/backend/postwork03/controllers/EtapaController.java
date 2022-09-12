package org.bedu.java.backend.postwork03.controllers;

import org.bedu.java.backend.postwork03.model.Etapa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

import org.bedu.java.backend.postwork03.services.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RequestMapping("/etapa")
@RestController
@RequiredArgsConstructor
public class EtapaController {

    private final EtapaService etapaService;

    @GetMapping("/{etapaId}")
    public ResponseEntity<Etapa> getEtapa(@PathVariable Long etapaId){
        Optional<Etapa> etapaDb = etapaService.obtenEtapa(etapaId);

        if (etapaDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La etapa especificada no existe.");
        }

        return ResponseEntity.ok(etapaDb.get());
    }

    @GetMapping
    public ResponseEntity <List<Etapa>> getEtapas(@Valid @RequestParam Long clienteId){
        return ResponseEntity.ok(etapaService.obtenEtapas());
    }

    @PostMapping
    public ResponseEntity<Void> creaEtapa(@Valid @RequestBody Etapa etapa, @RequestParam Long clienteId){

         Etapa etapaNueva = etapaService.guardaEtapa(etapa);

        return ResponseEntity.created(URI.create(String.valueOf(etapaNueva.getEtapaId()))).build();
    }

    @PutMapping("/{etapaId}")
    public ResponseEntity<Void> actualizaEtapa(@PathVariable Long etapaId, @Valid @RequestBody Etapa etapa){

        etapaService.actualizaEtapa(etapa);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{etapaId}")
    public ResponseEntity<Void> eliminaEtapa(@PathVariable Long etapaId){

        etapaService.eliminaEtapa(etapaId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}