package com.sistema_ventas.sistema_ventas.dto;

import java.time.LocalDate;

public class VentaDTO {

    private int id;
    private float total;
    private LocalDate fecha;

    public VentaDTO(int id, float total,LocalDate fecha) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
