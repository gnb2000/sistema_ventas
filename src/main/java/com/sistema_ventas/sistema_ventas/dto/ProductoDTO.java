package com.sistema_ventas.sistema_ventas.dto;

public class ProductoDTO {

    private int codigo;
    private float precio;
    private String nombre;
    private int cantidad;

    public ProductoDTO(int codigo, float precio, String nombre,int cantidad) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
