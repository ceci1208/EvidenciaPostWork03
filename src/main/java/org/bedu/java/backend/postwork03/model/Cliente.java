package org.bedu.java.backend.postwork03.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;


//Lombok annotation that provides all the setters and getters.
@Data

//Lombok annotation that automatically allows to chain its methods (for example = setters)
@Builder

public class Cliente {
    
    //Annotation that indicates that the id value must be positive or zero to be accepted.
    @PositiveOrZero(message = "The ID cannot be a negative number")
    private long id;

    //Annotation that indicates that the String nombre must not be empty
    @NotEmpty(message = "Customer Name cannot be empty")
    
    //Annotation that allows to delimitate the size of the variable.
    @Size(min = 5, max = 30, message = "The client's name must have at least 5 letters and be less than 30")
    private String nombre;

    //Anotation that indicates that the variable must be a valid email. 
    @Email
    private String correoContacto;

    //Annotation that delimitates the min. and max. of a number. 
    @Min(value = 10, message = "Customers with less than 10 employees are not valid")
    @Max(value = 10000, message = "Customers with more than 10,000 employees are not valid")
    private String numeroEmpleados;

    //Annotation that indicates that the address can't be empty or a blank space. 
    @NotBlank(message = "Address must be provided")
    private String direccion;


}
