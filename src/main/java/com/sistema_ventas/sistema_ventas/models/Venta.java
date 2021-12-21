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

    public Venta(float total,LocalDate fecha) {
        this.total = total;
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

    public void agregarProducto(Producto producto,int cantidad){
        boolean alreadyExists = false;
        ItemVenta aux = null;
        for (ItemVenta iv : this.productos){
            if (Integer.compare(iv.getProducto().getCodigo(),producto.getCodigo()) == 0){
                alreadyExists = true;
                aux = iv;
            }
        }
        if (alreadyExists == true){
            aux.setCantidad(aux.getCantidad() + 1);
        } else {
            aux = new ItemVenta(producto,cantidad,this);
            this.productos.add(aux);
        }
        this.actualizarTotal();
    }

    public void eliminarProducto(ItemVenta itemVenta){
        if (itemVenta.getCantidad() == 1){
            this.getProductos().remove(itemVenta);
        } else {
            itemVenta.setCantidad(itemVenta.getCantidad() - 1);
        }
        this.actualizarTotal();
    }


    public void actualizarTotal(){
        float precioNuevo = 0;
        for (ItemVenta iv : this.productos){
            precioNuevo += iv.getCantidad() * iv.getProducto().getPrecio();
        }
        this.total = precioNuevo;
    }

    public VentaDTO toDTO(){
        return new VentaDTO(this.id,this.total,this.fecha);
    }
}
