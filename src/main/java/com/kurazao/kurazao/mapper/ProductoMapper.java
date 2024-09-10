package com.kurazao.kurazao.mapper;

import com.kurazao.kurazao.dto.ProductoDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductoMapper implements RowMapper<ProductoDto> {
    @Override
    public ProductoDto mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductoDto p= new ProductoDto();

        p.setNombre(resultSet.getString("nombre"));
        p.setDescripcion(resultSet.getString("descripcion"));
        p.setCosto(resultSet.getDouble("costo"));
        p.setPrecio_venta(resultSet.getDouble("precio_venta"));
        p.setCantidad_inventario(resultSet.getInt("cantidad_inventario"));


        return p;
    }
}
