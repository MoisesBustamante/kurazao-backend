package com.kurazao.kurazao.mapper;

import com.kurazao.kurazao.dto.GastoDto;
import com.kurazao.kurazao.dto.ProductoDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GastoMapper implements RowMapper<GastoDto> {
    @Override
    public GastoDto mapRow(ResultSet resultSet, int i) throws SQLException {
        GastoDto p= new GastoDto();

        p.setDescripcion(resultSet.getString("descripcion"));
        p.setMonto(resultSet.getDouble("monto"));



        return p;
    }
}
