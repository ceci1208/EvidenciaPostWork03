package org.bedu.java.backend.postwork03.persistance.entities;



import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table(name = "SALES")
@Entity
@NoArgsConstructor
public class VentaDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ventaId;

    @PositiveOrZero
    private float monto;

    @OneToMany
    private List<ProductoDto> productos;

    @NotNull
    @ManyToOne
    private ClienteDto cliente;

    @PastOrPresent
    @Column(nullable = false, name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    
}
