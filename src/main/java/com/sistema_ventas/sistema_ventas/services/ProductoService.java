package com.sistema_ventas.sistema_ventas.services;

import com.sistema_ventas.sistema_ventas.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    void saveProduct(Producto p) throws Exception;
    Producto findProductoById(Integer id) throws Exception;
    void updateProducto(Producto p);
    void deleteProducto(Producto p);
    List<Producto> getAllProductos();

}
