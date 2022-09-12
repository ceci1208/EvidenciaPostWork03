package org.bedu.java.backend.postwork03.persistance;

import org.bedu.java.backend.postwork03.persistance.entities.VisitaDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitaRepository extends JpaRepository<VisitaDto,Long> {
    
}
