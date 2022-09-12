package org.bedu.java.backend.postwork03.persistance;

import org.bedu.java.backend.postwork03.persistance.entities.ClienteDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteDto, Long> {
    
}
