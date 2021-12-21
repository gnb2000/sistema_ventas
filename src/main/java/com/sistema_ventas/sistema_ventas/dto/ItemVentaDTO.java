package com.sistema_ventas.sistema_ventas.dto;

import com.sistema_ventas.sistema_ventas.models.Producto;

public class ItemVentaDTO {

    private int id;
    private int idProducto;
    private int cantidad;
    private float total;
    private int idVenta;

    public ItemVentaDTO(int id, int idProducto, int cantidad, float total, int idVenta) {
        this.id = id;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.total = total;
        this.idVenta = idVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
}
