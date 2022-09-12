package org.bedu.java.backend.postwork03.runner;

import java.time.LocalDateTime;

import org.bedu.java.backend.postwork03.model.DateTime;
import org.bedu.java.backend.postwork03.persistance.DateTimeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SesionRunner implements CommandLineRunner{
    
    private final DateTimeRepository dateTimeRepository;
    @Override
    public void run(String... args) throws Exception {
   
        DateTime sesion = creaSesion(LocalDateTime.now());
        dateTimeRepository.save(sesion);

    }
    private DateTime creaSesion(LocalDateTime time) {
        DateTime sesion = new DateTime();
        sesion.setInicioSesion(LocalDateTime.now());
  

        return sesion;
    }
    
}
