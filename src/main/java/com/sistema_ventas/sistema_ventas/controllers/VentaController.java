package com.sistema_ventas.sistema_ventas.controllers;

import com.sistema_ventas.sistema_ventas.dto.VentaDTO;
import com.sistema_ventas.sistema_ventas.models.ItemVenta;
import com.sistema_ventas.sistema_ventas.models.Producto;
import com.sistema_ventas.sistema_ventas.models.Venta;
import com.sistema_ventas.sistema_ventas.repositories.ItemVentaRepository;
import com.sistema_ventas.sistema_ventas.repositories.VentaRepository;
import com.sistema_ventas.sistema_ventas.services.ItemVentaService;
import com.sistema_ventas.sistema_ventas.services.ProductoService;
import com.sistema_ventas.sistema_ventas.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ItemVentaService itemVentaService;

    @Autowired
    private ProductoService productoService;

    @PostMapping("/venta/{fecha}/{total}")
    public void createVenta(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha, @PathVariable float total) throws Exception {
        Venta v = new Venta(total,fecha);
        ventaService.save(v);
    }

    @PutMapping("/venta/{id}/{fecha}/{total}/{items_venta}")
    public void updateVenta(@PathVariable Integer id,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha,@PathVariable float total,@PathVariable String[] items_venta) throws Exception {
        Venta venta = ventaService.getVentaById(id);
        List<ItemVenta> itemsVenta = this.getItemsVentaByIds(items_venta);
        venta.setFecha(fecha);
        venta.setTotal(total);
        venta.setProductos(itemsVenta);
        ventaService.save(venta);
    }

    @RequestMapping("/venta/{id}")
    public VentaDTO getVentaById(@PathVariable Integer id) throws Exception {
        Venta v = ventaService.getVentaById(id);
        return v.toDTO();
    }

    @DeleteMapping("/venta/{id}")
    public void deleteVentaById(@PathVariable Integer id) throws Exception {
        Venta v = ventaService.getVentaById(id);
        ventaService.delete(v);
    }

    @PutMapping("/venta/{venta_id}/producto/{producto_id}/{cantidad}")
    public void agregarProducto(@PathVariable int venta_id, @PathVariable int producto_id,@PathVariable int cantidad) throws Exception {
        Venta venta = ventaService.getVentaById(venta_id);
        Producto producto = productoService.findProductoById(producto_id);
        venta.agregarProducto(producto,cantidad);
        ventaService.update(venta);
    }

    @RequestMapping("/ventas")
    public List<VentaDTO> getAllVentas(){
        List<VentaDTO> ventasDTO = new ArrayList<VentaDTO>();
        List<Venta> ventas = ventaService.getAllVentas();
        for (Venta v : ventas){
            ventasDTO.add(v.toDTO());
        }
        return ventasDTO;
    }


    private List<ItemVenta> getItemsVentaByIds(String[] items_venta) throws Exception {
        List<ItemVenta> itemsVenta = new ArrayList<ItemVenta>();
        for (String i : items_venta){
            ItemVenta item_venta = itemVentaService.getItemVentaById(Integer.valueOf(i));
            itemsVenta.add(item_venta);
        }
        return itemsVenta;
    }
}
