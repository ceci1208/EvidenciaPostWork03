package org.bedu.java.backend.postwork03.persistance;

import org.bedu.java.backend.postwork03.persistance.entities.VentaDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<VentaDto, Long> {
    
}
