package org.bedu.java.backend.postwork03.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bedu.java.backend.postwork03.controllers.mappers.ProductoMapper;
import org.bedu.java.backend.postwork03.model.Producto;
import org.bedu.java.backend.postwork03.persistance.ProductoRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository repository;
    private final ProductoMapper mapper;

    public Producto guardaProducto(Producto producto) {
        return mapper.productoDtoToProducto(
            repository.save(mapper.productoToProductoDto(producto)));
    }

    public List<Producto> obtenProductos(){
        return repository.findAll().stream().map(Producto -> mapper.productoDtoToProducto(Producto)).collect(Collectors.toList());
    }

    public Optional<Producto> obtenProducto(long idProducto) {
        return repository.findById(idProducto)
                .map(producto -> Optional.of(mapper.productoDtoToProducto(producto)))
                .orElse(Optional.empty());
    }

    public void eliminaProducto(long idProducto){
        repository.deleteById(idProducto);
    }

    public Producto actualizaProducto(Producto producto){
        return mapper.productoDtoToProducto(
                repository.save(mapper.productoToProductoDto(producto))
        );
    }

    public long cuenteProductos(){
        return repository.count();
    }
}