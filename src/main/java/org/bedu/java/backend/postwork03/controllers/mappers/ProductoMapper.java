package org.bedu.java.backend.postwork03.controllers.mappers;

import org.bedu.java.backend.postwork03.model.Producto;
import org.bedu.java.backend.postwork03.persistance.entities.ProductoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto productoDtoToProducto(ProductoDto productoDto);

    ProductoDto productoToProductoDto(Producto producto);
}
