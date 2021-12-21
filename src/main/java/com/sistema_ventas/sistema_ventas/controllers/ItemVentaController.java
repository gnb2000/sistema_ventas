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

@RestController
public class ItemVentaController {

    @Autowired
    private ItemVentaService itemVentaService;

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductoService productoService;

    @PostMapping("/itemVenta/{producto_id}/{venta_id}/{cantidad}")
    public void createItemVenta(@PathVariable Integer producto_id, @PathVariable Integer venta_id,@PathVariable Integer cantidad) throws Exception {
        Venta venta = ventaService.getVentaById(venta_id);
        Producto producto = productoService.findProductoById(producto_id);
        venta.agregarProducto(producto,cantidad);
        ventaService.update(venta);
    }

    @PutMapping("/itemVenta/{id}/{producto_id}/{venta_id}/{cantidad}")
    public void updateItemVenta(@PathVariable Integer id,@PathVariable Integer producto_id, @PathVariable Integer venta_id,@PathVariable Integer cantidad) throws Exception {
        ItemVenta itemVenta = itemVentaService.getItemVentaById(id);
        Venta v = ventaService.getVentaById(venta_id);
        Producto p = productoService.findProductoById(producto_id);
        itemVenta.setVenta(v);
        itemVenta.setProducto(p);
        itemVenta.setCantidad(cantidad);
        itemVentaService.update(itemVenta);
        v.actualizarTotal();
        ventaService.update(v);
    }

    @DeleteMapping("/itemVenta/{id}")
    public void deleteItemVenta(@PathVariable Integer id) throws Exception {
        ItemVenta itemVenta = itemVentaService.getItemVentaById(id);
        Venta v = itemVenta.getVenta();
        v.eliminarProducto(itemVenta);
        ventaService.update(v);
    }

    @RequestMapping("/itemVenta/{id}")
    public ItemVentaDTO getItemVentaById(@PathVariable Integer id) throws Exception {
        return itemVentaService.getItemVentaById(id).toDTO();
    }


}