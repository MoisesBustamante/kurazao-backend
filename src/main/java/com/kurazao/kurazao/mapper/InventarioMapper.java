package com.kurazao.kurazao.mapper;

import com.kurazao.kurazao.dto.GastoDto;
import com.kurazao.kurazao.dto.InventarioDto;
import com.kurazao.kurazao.dto.ProductoDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventarioMapper implements RowMapper<InventarioDto> {
    @Override
    public InventarioDto mapRow(ResultSet resultSet, int i) throws SQLException {
        InventarioDto p= new InventarioDto();
        ProductoDto pr= new ProductoDto();

        pr.setId_producto(resultSet.getInt("id_producto"));
        p.setCantidad(resultSet.getInt("cantidad_agregada"));



        return p;
    }
}
