package org.bedu.java.backend.postwork03.model;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

//Lombok annotation that provides all the setters and getters.
@Data

//Lombok annotation that automatically allows to chain its methods (for example = setters)
@Builder

public class Producto {
    
    //Annotation that indicates that the id value must be positive or zero to be accepted.
    @PositiveOrZero(message = "The ID cannot be a negative number.")
    private long id;

    //Annotation that indicates that the id value must be positive or zero to be accepted.
    @NotEmpty(message = "Product Name cannot be empty.")
    //Annotation that allows to delimitate the size of the variable.
    @Size(min = 4, max = 30, message = "The product name must be between 4 and 30 letters.")
    private String nombre;

    private String categoria;

     //Annotation that indicates that a float value must have a minimun value.
    @DecimalMin(value = "1.00", inclusive = true, message = "Prodcut price must be at least 1.00")
    private float precio;

    //Annotation that indicates that the variable must not be empty.
    @NotEmpty(message = "The product registration number cannot be blank.")
    //Annotation that provides a pattern to fill the variable.
    @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$")
    private String numeroRegistro;

     //Annotation that indicates that the DateTime value can't be a future date.
    @PastOrPresent(message = "The product creation date cannot be in the future.")
    private LocalDate fechaCreacion;

}