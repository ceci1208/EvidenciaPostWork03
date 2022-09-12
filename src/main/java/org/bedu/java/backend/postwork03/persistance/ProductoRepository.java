package org.bedu.java.backend.postwork03.persistance;

import org.bedu.java.backend.postwork03.persistance.entities.ProductoDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoDto, Long>{
    
}
