package com.sistema_ventas.sistema_ventas.services;

import com.sistema_ventas.sistema_ventas.models.Venta;
import com.sistema_ventas.sistema_ventas.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService{

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public void save(Venta v) {
        ventaRepository.save(v);
    }

    @Override
    public void update(Venta v) {
        ventaRepository.save(v);
    }

    @Override
    public void delete(Venta v) {
        ventaRepository.delete(v);
    }

    @Override
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentaById(Integer id) throws Exception {
        Optional<Venta> venta = ventaRepository.findById(id);
        if (venta.isPresent()){
            return venta.get();
        }
        throw new Exception("There is no a sale with id "+id);
    }


}
