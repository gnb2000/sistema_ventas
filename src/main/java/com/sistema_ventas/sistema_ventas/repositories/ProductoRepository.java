package com.sistema_ventas.sistema_ventas.repositories;

import com.sistema_ventas.sistema_ventas.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
