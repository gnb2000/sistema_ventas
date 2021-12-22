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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class ItemVentaController {

    @Autowired
    private ItemVentaService itemVentaService;

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductoService productoService;

    @PutMapping("/itemVenta/{producto_id}/{venta_id}/{cantidad}")
    public void createItemVenta(@PathVariable Integer producto_id, @PathVariable Integer venta_id,@PathVariable Integer cantidad) throws Exception {
        Venta venta = ventaService.getVentaById(venta_id);
        Producto producto = productoService.findProductoById(producto_id);
        producto.setCantidad(producto.getCantidad() - cantidad);
        venta.agregarProducto(producto,cantidad);
        productoService.updateProducto(producto);
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
        itemVenta.getProducto().setCantidad(itemVenta.getCantidad() + itemVenta.getProducto().getCantidad());
        ventaService.update(v);
    }

    @RequestMapping("/itemVenta/{id}")
    public ItemVentaDTO getItemVentaById(@PathVariable Integer id) throws Exception {
        return itemVentaService.getItemVentaById(id).toDTO();
    }

    @RequestMapping("/itemsVenta/{venta_id}")
    public List<ItemVentaDTO> getItemsVentaByVenta(@PathVariable Integer venta_id){
        List<ItemVenta> itemVenta = itemVentaService.getItemsVentaByVenta(venta_id);
        List<ItemVentaDTO> itemVentaDTO = new ArrayList<ItemVentaDTO>();
        for (ItemVenta iv : itemVenta){
            itemVentaDTO.add(iv.toDTO());
        }
        return itemVentaDTO;
    }


}
