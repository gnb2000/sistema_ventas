package com.sistema_ventas.sistema_ventas.controllers;

import com.sistema_ventas.sistema_ventas.dto.ProductoDTO;
import com.sistema_ventas.sistema_ventas.models.Producto;
import com.sistema_ventas.sistema_ventas.repositories.ProductoRepository;
import com.sistema_ventas.sistema_ventas.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
        Producto producto = productoService.findProductoById(id);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        productoService.saveProduct(producto);
    }

    @RequestMapping("/producto/{id}")
    public ProductoDTO getProductoById(@PathVariable int id) throws Exception {
        Producto p = productoService.findProductoById(id);
        return p.toDTO();
    }

    @DeleteMapping("/producto/{id}")
    public void deleteProductoById(@PathVariable int id) throws Exception {
        Producto p = productoService.findProductoById(id);
        productoService.deleteProducto(p);
    }

    @RequestMapping("/productos")
    public List<ProductoDTO> getAllProductos(){
        List<ProductoDTO> productosDTO = new ArrayList<ProductoDTO>();
        List<Producto> productos = productoService.getAllProductos();
        for (Producto p : productos){
            productosDTO.add(p.toDTO());
        }
        return productosDTO;
    }




}
