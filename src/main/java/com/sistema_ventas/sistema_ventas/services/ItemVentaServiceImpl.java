package com.sistema_ventas.sistema_ventas.services;

import com.sistema_ventas.sistema_ventas.models.ItemVenta;
import com.sistema_ventas.sistema_ventas.repositories.ItemVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVentaServiceImpl implements ItemVentaService{

    @Autowired
    private ItemVentaRepository itemVentaRepository;


    @Override
    public void save(ItemVenta iv) {
        itemVentaRepository.save(iv);
    }

    @Override
    public void update(ItemVenta iv) {
        itemVentaRepository.save(iv);
    }

    @Override
    public void delete(ItemVenta iv) {
        itemVentaRepository.delete(iv);
    }

    @Override
    public List<ItemVenta> getAllItemsVenta() {
        return itemVentaRepository.findAll();
    }

    @Override
    public ItemVenta getItemVentaById(Integer id) throws Exception {
        Optional<ItemVenta> itemVenta = itemVentaRepository.findById(id);
        if (itemVenta.isPresent()){
            return itemVenta.get();
        } else {
            throw new Exception("There is no a sale_item with id "+id);
        }
    }

    @Override
    public List<ItemVenta> getItemsVentaByVenta(Integer id) {
        System.out.println(id);
        return itemVentaRepository.findByVenta(id);
    }
}
