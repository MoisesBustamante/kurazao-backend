package com.kurazao.kurazao.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter

public class ProductoDto {
    private int id_producto;
    private String nombre;
    private String descripcion;
    private double costo;
    private double precio_venta;
    private int cantidad_inventario;
    private LocalDateTime fecha_creacion;
}
