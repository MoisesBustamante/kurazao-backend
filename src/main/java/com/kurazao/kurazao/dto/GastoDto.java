package com.kurazao.kurazao.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data

public class GastoDto {
    private int id_gasto;
    private  String descripcion;
    private Double monto;
    private LocalDateTime fecha_gasto;
}
