package com.kurazao.kurazao.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data

public class InventarioDto {
    private Integer id_inventario;
    private ProductoDto productoDto;
    private  Integer cantidad;
    private LocalDateTime fecha_actualizacion;
}
