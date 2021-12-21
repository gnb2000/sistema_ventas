package com.sistema_ventas.sistema_ventas.models;

import com.sistema_ventas.sistema_ventas.dto.VentaDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="ventas")
public class Venta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float total;
    private LocalDate fecha;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenta> productos;

    public Venta(){}

    public Venta(float total,LocalDate fecha, List<ItemVenta> productos) {
        this.total = total;
        this.productos = productos;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<ItemVenta> getProductos() {
        return productos;
    }

    public void setProductos(List<ItemVenta> productos) {
        this.productos = productos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public VentaDTO toDTO(){
        return new VentaDTO(this.id,this.total,this.fecha);
    }
}
