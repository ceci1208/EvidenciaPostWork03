package org.bedu.java.backend.postwork03.persistance.entities;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CUSTOMERS")
@NoArgsConstructor
public class ClienteDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "email", nullable = false)
    private String correoContacto;


    @Column(name = "employeesNumber", nullable = false)
    private String numeroEmpleados;

    private String direccion;
}
