package com.kurazao.kurazao.dto;

import lombok.Data;

import java.io.Serial;
import java.time.LocalDateTime;
@Data

public class VentasDto {
    private Serial id_venta;
    private ProductoDto productoDto;
    private  Integer cantidad;
    private  Number total;
    private LocalDateTime fecha_venta;
}
