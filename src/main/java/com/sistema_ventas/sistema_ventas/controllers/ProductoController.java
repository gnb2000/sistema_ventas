package com.sistema_ventas.sistema_ventas.controllers;

import com.sistema_ventas.sistema_ventas.dto.ProductoDTO;
import com.sistema_ventas.sistema_ventas.models.Producto;
import com.sistema_ventas.sistema_ventas.repositories.ProductoRepository;
import com.sistema_ventas.sistema_ventas.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/producto/{nombre}/{precio}")
    public void crearProducto(@PathVariable String nombre, @PathVariable float precio) throws Exception {
        Producto producto = new Producto(precio,nombre);
        productoService.saveProduct(producto);
    }

    @PutMapping("/producto/{id}/{nombre}/{precio}")
    public void actualizarProducto(@PathVariable int id, @PathVariable String nombre, @PathVariable float precio) throws Exception {
        Optional<Producto> p = productoService.findProductoById(id);
        if (p.isPresent()){
            Producto producto = p.get();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            productoService.saveProduct(producto);
        } else {
            throw new Exception("There is no Product with id "+id);
        }
    }

    @RequestMapping("/producto/{id}")
    public ProductoDTO getProductoById(@PathVariable int id) throws Exception {
        Optional<Producto> p = productoService.findProductoById(id);
        if (p.isPresent()){
            return p.get().toDTO();
        } else {
            throw new Exception("There is no Product with id "+id);
        }
    }

    @DeleteMapping("/producto/{id}")
    public void deleteProductoById(@PathVariable int id) throws Exception {
        Optional<Producto> p = productoService.findProductoById(id);
        if (p.isPresent()){
            productoService.deleteProducto(p.get());
        } else {
            throw new Exception("There is no Product with id "+id);
        }
    }




}
