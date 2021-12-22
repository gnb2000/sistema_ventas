package com.sistema_ventas.sistema_ventas.repositories;

import com.sistema_ventas.sistema_ventas.models.ItemVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemVentaRepository extends JpaRepository<ItemVenta,Integer> {

    @Query("select i from ItemVenta i where i.venta.id = :id")
    List<ItemVenta> findByVenta(@Param("id") Integer id);
}
