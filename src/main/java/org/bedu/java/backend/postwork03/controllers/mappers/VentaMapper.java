package org.bedu.java.backend.postwork03.controllers.mappers;

import org.bedu.java.backend.postwork03.model.Venta;
import org.bedu.java.backend.postwork03.persistance.entities.VentaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    Venta ventaDtoToVenta(VentaDto ventaDto);

    VentaDto ventaToVentaDto(Venta venta);
}
