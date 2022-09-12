package org.bedu.java.backend.postwork03.model;

import java.time.LocalDateTime;
import java.util.Map;
import org.bedu.java.backend.postwork03.model.builders.RespuestaErrorBuilder;

import lombok.Data;

@Data
public class RespuestaError {

    private final LocalDateTime timestamp = LocalDateTime.now();
    private int estatus;
    private String mensaje;
    private Map<String, String> errores;
    private String ruta;

    public static RespuestaErrorBuilder builder() {
        return new RespuestaErrorBuilder();
    }

}