package com.sistema_ventas.sistema_ventas.dto;

import com.sistema_ventas.sistema_ventas.models.Producto;

public class ItemVentaDTO {

    private int id;
    private int idProducto;
    private int cantidad;
    private int idVenta;

    public ItemVentaDTO(int id, int idProducto, int cantidad, int idVenta) {
        this.id = id;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
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

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
}
