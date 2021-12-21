package com.sistema_ventas.sistema_ventas.repositories;

import com.sistema_ventas.sistema_ventas.models.ItemVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVentaRepository extends JpaRepository<ItemVenta,Integer> {
}
