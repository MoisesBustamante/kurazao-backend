package com.kurazao.kurazao.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data

public class GastoDto {
    private int id_gasto;
    private  String descripcion;
    private String monto;
    private LocalDateTime fecha_gasto;
}
