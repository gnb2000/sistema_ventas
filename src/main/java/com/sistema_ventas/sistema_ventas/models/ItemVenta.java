package com.sistema_ventas.sistema_ventas.models;

import com.sistema_ventas.sistema_ventas.dto.ItemVentaDTO;

import javax.persistence.*;

@Entity
@Table(name="itemVentas")
public class ItemVenta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne()
    @JoinColumn(name = "venta_id")
    private Venta venta;

    private int cantidad;

    public ItemVenta(){}

    public ItemVenta(Producto producto, int cantidad, Venta venta) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.venta = venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public ItemVentaDTO toDTO(){
        return new ItemVentaDTO(this.id,this.getProducto().getCodigo(),this.cantidad,this.getVenta().getId());
    }
}
