package com.sistema_ventas.sistema_ventas.services;

import com.sistema_ventas.sistema_ventas.models.Venta;

import java.util.List;
import java.util.Optional;

public interface VentaService {

    void save(Venta v);
    void update(Venta v);
    void delete(Venta v);
    List<Venta> getAllVentas();
    Venta getVentaById(Integer id) throws Exception;


}
