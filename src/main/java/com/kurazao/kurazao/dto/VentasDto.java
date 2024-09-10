package com.kurazao.kurazao.dto;

import java.io.Serial;
import java.time.LocalDateTime;

public class VentasDto {
    private Serial id_venta;
    private ProductoDto productoDto;
    private  Integer cantidad;
    private  Number total;
    private LocalDateTime fecha_venta;
}
