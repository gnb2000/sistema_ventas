package com.sistema_ventas.sistema_ventas.controllers;

import com.sistema_ventas.sistema_ventas.dto.VentaDTO;
import com.sistema_ventas.sistema_ventas.models.ItemVenta;
import com.sistema_ventas.sistema_ventas.models.Venta;
import com.sistema_ventas.sistema_ventas.repositories.ItemVentaRepository;
import com.sistema_ventas.sistema_ventas.repositories.VentaRepository;
import com.sistema_ventas.sistema_ventas.services.ItemVentaService;
import com.sistema_ventas.sistema_ventas.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ItemVentaService itemVentaService;

    @PostMapping("/venta/{fecha}/{total}/{items_venta}")
    public void createVenta(@PathVariable LocalDate fecha,@PathVariable float total,@PathVariable String[] items_venta){
        List<ItemVenta> itemsVenta = this.getItemsVentaByIds(items_venta);
        Venta v = new Venta(total,fecha,itemsVenta);
        ventaService.save(v);
    }

    @PutMapping("/venta/{id}/{fecha}/{total}/{items_venta}")
    public void updateVenta(@PathVariable Integer id,@PathVariable LocalDate fecha,@PathVariable float total,@PathVariable String[] items_venta) throws Exception {
        Optional<Venta> v = ventaService.getVentaById(id);
        if (v.isPresent()){
            List<ItemVenta> itemsVenta = this.getItemsVentaByIds(items_venta);
            Venta venta = v.get();
            venta.setFecha(fecha);
            venta.setTotal(total);
            venta.setProductos(itemsVenta);
            ventaService.save(venta);
        } else {
            throw new Exception("There is NO a sale with id"+id);
        }

    }

    @RequestMapping("/venta/{id}")
    public VentaDTO getVentaById(@PathVariable Integer id) throws Exception {
        Optional<Venta> v = ventaService.getVentaById(id);
        if (v.isPresent()){
            return v.get().toDTO();
        } else {
            throw new Exception("There is NO a sale with id"+id);
        }
    }

    @DeleteMapping("/venta/{id}")
    public void deleteVentaById(@PathVariable Integer id) throws Exception {
        Optional<Venta> v = ventaService.getVentaById(id);
        if (v.isPresent()){
            ventaService.delete(v.get());
        } else {
            throw new Exception("There is NO a sale with id"+id);
        }
    }


    private List<ItemVenta> getItemsVentaByIds(String[] items_venta){
        List<ItemVenta> itemsVenta = new ArrayList<ItemVenta>();
        for (String i : items_venta){
            Optional<ItemVenta> item_venta = itemVentaService.getItemVentaById(Integer.valueOf(i));
            if (item_venta.isPresent()){
                itemsVenta.add(item_venta.get());
            }
        }
        return itemsVenta;
    }
}
