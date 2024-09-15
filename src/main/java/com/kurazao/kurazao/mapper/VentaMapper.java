package com.kurazao.kurazao.mapper;


import com.kurazao.kurazao.dto.InventarioDto;
import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.dto.VentasDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaMapper implements RowMapper<VentasDto> {

    @Override
    public VentasDto mapRow(ResultSet resultSet, int i) throws SQLException {
        VentasDto p= new VentasDto();
        ProductoDto pr= new ProductoDto();

        pr.setId_producto(resultSet.getInt("id_producto"));
        p.setCantidad(resultSet.getInt("cantidad"));
        p.setTotal(resultSet.getInt("total"));



        return p;
    }
}
