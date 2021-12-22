package com.sistema_ventas.sistema_ventas.services;

import com.sistema_ventas.sistema_ventas.models.ItemVenta;

import java.util.List;
import java.util.Optional;

public interface ItemVentaService {

    void save(ItemVenta iv);
    void update(ItemVenta iv);
    void delete(ItemVenta iv);
    List<ItemVenta> getAllItemsVenta();
    ItemVenta getItemVentaById(Integer id) throws Exception;
    List<ItemVenta> getItemsVentaByVenta(Integer id);


}
