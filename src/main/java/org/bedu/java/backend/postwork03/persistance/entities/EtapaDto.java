package org.bedu.java.backend.postwork03.persistance.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Table(name = "STAGES")
@Entity
@NoArgsConstructor
public class EtapaDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long etapaId;

    private String nombre;

    @Column(unique = true, nullable = false)
    private Integer orden;
    
}
