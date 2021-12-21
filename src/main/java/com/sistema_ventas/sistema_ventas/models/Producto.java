package com.sistema_ventas.sistema_ventas.models;

import com.sistema_ventas.sistema_ventas.dto.ProductoDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="productos")
public class Producto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private float precio;
    private String nombre;
    private int cantidad;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenta> itemVenta;

    public Producto(){}

    public Producto(float precio, String nombre,int cantidad) {
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

    public List<ItemVenta> getItemVenta() {
        return itemVenta;
    }

    public void setItemVenta(List<ItemVenta> itemVenta) {
        this.itemVenta = itemVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoDTO toDTO(){
        return new ProductoDTO(this.codigo,this.precio,this.nombre,this.cantidad);
    }
}
