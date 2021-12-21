package com.sistema_ventas.sistema_ventas.controllers;

import com.sistema_ventas.sistema_ventas.dto.ItemVentaDTO;
import com.sistema_ventas.sistema_ventas.models.ItemVenta;
import com.sistema_ventas.sistema_ventas.models.Producto;
import com.sistema_ventas.sistema_ventas.models.Venta;
import com.sistema_ventas.sistema_ventas.repositories.ItemVentaRepository;
import com.sistema_ventas.sistema_ventas.repositories.VentaRepository;
import com.sistema_ventas.sistema_ventas.services.ItemVentaService;
import com.sistema_ventas.sistema_ventas.services.ProductoService;
import com.sistema_ventas.sistema_ventas.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class ItemVentaController {

    @Autowired
    private ItemVentaService itemVentaService;

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductoService productoService;



    @PostMapping("/itemVenta/{producto_id}/{venta_id}/{cantidad}/{total}")
    public void createItemVenta(@PathVariable Integer producto_id, @PathVariable Integer venta_id,@PathVariable Integer cantidad,@PathVariable float total) throws Exception {
        Venta v = ventaService.getVentaById(venta_id);
        Producto p = productoService.findProductoById(producto_id);
        ItemVenta iv = new ItemVenta(p,cantidad,total,v);
        itemVentaService.save(iv);
    }

    @PutMapping("/itemVenta/{id}/{producto_id}/{venta_id}/{cantidad}/{total}")
    public void updateItemVenta(@PathVariable Integer id,@PathVariable Integer producto_id, @PathVariable Integer venta_id,@PathVariable Integer cantidad,@PathVariable float total) throws Exception {
        ItemVenta itemVenta = itemVentaService.getItemVentaById(id);
        Venta v = ventaService.getVentaById(venta_id);
        Producto p = productoService.findProductoById(producto_id);
        itemVenta.setVenta(v);
        itemVenta.setProducto(p);
        itemVenta.setCantidad(cantidad);
        itemVenta.setTotal(total);
        itemVentaService.update(itemVenta);
    }

    @DeleteMapping("/itemVenta/{id}")
    public void deleteItemVenta(@PathVariable Integer id) throws Exception {
        ItemVenta itemVenta = itemVentaService.getItemVentaById(id);
        itemVentaService.delete(itemVenta);
    }

    @RequestMapping("/itemVenta/{id}")
    public ItemVentaDTO getItemVentaById(@PathVariable Integer id) throws Exception {
        return itemVentaService.getItemVentaById(id).toDTO();

    }


}
