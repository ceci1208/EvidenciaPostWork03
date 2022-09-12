package org.bedu.java.backend.postwork03.model;

import javax.validation.constraints.*;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

//Lombok annotation that provides all the setters and getters.
@Data

//Lombok annotation that automatically allows to chain its methods (for example = setters)
@Builder

public class Visita {
    
    //Annotation that indicates that the id value must be positive or zero to be accepted.
    @PositiveOrZero(message = "The ID cannot be a negative number.")
    private long id;

    //Annotation that indicates that the private Cliente must not be empty
    @NotNull(message = "The visit must have been made to a client.")
    private Cliente cliente;

    //Annotation that indicates that the DateTime value can only be a future date.
    @Future(message = "The appointment date cannot be on a date in the past.")
    private LocalDateTime fechaProgramada;

    //Annotation that indicates that the variable must not be empty
    @NotEmpty(message = "The address cannot be blank.")
    //Annotation that allows to delimitate the size of the variable.
    @Size(min = 10, message = "The address must have at least 10 letters.")
    private String direccion;

    //Annotation that indicates that the variable must not be empty
    @NotEmpty(message = "The purpose of the visit cannot be blank.")
    //Annotation that allows to delimitate the size of the variable.
    @Size(min = 15, message = "The purpose of the visit must have at least 15 letters.")
    private String proposito;

    //Annotation that indicates that the variable must not be empty
    @NotEmpty(message = "Seller name cannot be blank.")
    //Annotation that allows to delimitate the size of the variable.
    @Size(min = 4, max = 30, message = "The seller's name must be between 4 and 30 letters.")
    private String vendedor;
}