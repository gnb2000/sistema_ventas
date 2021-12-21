package com.sistema_ventas.sistema_ventas.repositories;

import com.sistema_ventas.sistema_ventas.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Integer> {
}
