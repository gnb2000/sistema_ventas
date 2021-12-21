package com.sistema_ventas.sistema_ventas.services;

import com.sistema_ventas.sistema_ventas.models.Producto;
import com.sistema_ventas.sistema_ventas.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public void saveProduct(Producto p) throws Exception {
        try {
            productoRepository.save(p);
        } catch (NullPointerException e){
            throw new Exception("Product is NULL");
        }
    }

    @Override
    public Producto findProductoById(Integer id) throws Exception {
        Optional<Producto> p = productoRepository.findById(id);
        if (p.isPresent()){
            return p.get();
        }
        throw new Exception("There is NO a product with id "+id);
    }

    @Override
    public void updateProducto(Producto p) {
        productoRepository.save(p);
    }

    @Override
    public void deleteProducto(Producto p) {
        productoRepository.delete(p);
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }
}
