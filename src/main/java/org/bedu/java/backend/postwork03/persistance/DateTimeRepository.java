package org.bedu.java.backend.postwork03.persistance;

import org.bedu.java.backend.postwork03.model.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateTimeRepository extends JpaRepository<DateTime, Long> {
    
}
