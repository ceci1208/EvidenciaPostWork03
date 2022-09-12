package org.bedu.java.backend.postwork03.persistance;

import org.bedu.java.backend.postwork03.persistance.entities.EtapaDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtapaRepository extends JpaRepository<EtapaDto, Long> {
    
}
