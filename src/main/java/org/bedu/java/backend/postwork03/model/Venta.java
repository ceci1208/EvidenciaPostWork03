package org.bedu.java.backend.postwork03.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import lombok.Builder;
import lombok.Data;

//Lombok annotation that provides all the setters and getters.
@Data

//Lombok annotation that automatically allows to chain its methods (for example = setters)
@Builder

public class Venta {
    
    //Annotation that indicates that the id value must be positive or zero to be accepted.
    @PositiveOrZero(message = "The ID cannot be a negative number.")
    private long ventaId;

    //Annotation that indicates that a float value must have a minimun value.
    @DecimalMin(value = "1.00", inclusive = true, message = "The sale must be at least 1.00.")
    private float monto;

    //Annotation that indicates that the variable must not be empty
    @NotEmpty(message = "The sale must have at least one product.")
    private List<Producto> productos;

    //Annotation that indicates that the private Cliente must not be empty
    @NotNull(message = "The sale must have been made to a customer.")
    private Cliente cliente;

    //Annotation that indicates that the DateTime value can't be a future date.
    @PastOrPresent(message = "The sale cannot occur in the future.")
    private LocalDateTime fechaCreacion;

}