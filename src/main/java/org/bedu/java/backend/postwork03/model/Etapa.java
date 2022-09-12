package org.bedu.java.backend.postwork03.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.RequiredArgsConstructor;

//Lombok annotation that provides all the setters and getters.
@Data

//Lombok annotation that provides the constructor.
@RequiredArgsConstructor

public class Etapa {

    //Annotation that indicates that the id value must be positive or zero to be accepted.
    @PositiveOrZero(message = "The ID cannot be a negative number")
    private long etapaId;

    //Annotation that indicates that the String nombre must not be empty and must have between 4 and 30 letters 
    @NotEmpty(message = "Stage Name cannot be empty")
    @Size(min = 4, max = 30, message = "The name of the stage must have between 4 and 30 letters")
    private String nombre;

    //Annotation indicating that the orden value must be greater than zero.
    @Positive(message = "The stage must have a positive order greater than zero")
    private int orden;
}