package org.bedu.java.backend.postwork03.persistance.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "VISITAS")
@Entity
@NoArgsConstructor

public class VisitaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private ClienteDto cliente;

    @Column(nullable = false)
    private LocalDateTime fechaProgramada;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String proposito;

    @Column(nullable = false)
    private String vendedor;
}
