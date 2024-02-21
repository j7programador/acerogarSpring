package com.example.acero.controller;

import com.example.acero.entity.Producto;
import com.example.acero.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "acerogar/productos")
public class ProductoController {


    @Autowired
    private  ProductoService productoService;



    @GetMapping("/obtenerProductos")
    public List<Producto> obtenerProductos() {
        return productoService.getProductos();
    }

    @GetMapping("/obtenerProducto/{id}")
    public Optional<Producto> obtenerProducto(@PathVariable("id") Long id) {
        return productoService.getProductoById(id);
    }

    @PostMapping("/guardarProducto")
    public void guardarProducto(@RequestBody Producto producto) {
        productoService.guardarProducto(producto);
    }

    @PutMapping("/actualizar/{id}")
    public void actualizarProducto(@RequestBody Producto producto, @PathVariable("id") Long id) {
        productoService.actualizarProducto(producto, id);
    }


}
