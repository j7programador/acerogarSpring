package com.example.acero.service;


import com.example.acero.entity.Producto;
import com.example.acero.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;


    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public void actualizarProducto(Producto producto, Long id) {
        Producto productoActualizar = productoRepository.findById(id).get();
        productoActualizar.setNombre(producto.getNombre());
        productoActualizar.setDescripcion(producto.getDescripcion());
        productoActualizar.setPrecio(producto.getPrecio());
        productoRepository.save(productoActualizar);

    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public boolean isExiste(Long id) {
        return productoRepository.existsById(id);
    }
}
