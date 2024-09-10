package com.kurazao.kurazao.dao;

import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.exceptions.DaoExceptions;
import com.kurazao.kurazao.mapper.ProductoMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
@Repository

public class ProductoDaoImplements implements   ProductoDaoInterface{
    private JdbcTemplate jdbcTemplate;
    public ProductoDaoImplements(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
    @Override
    public void Insertar(ProductoDto productoDto) throws DaoExceptions {
        String INSERT="INSERT INTO productos(id_producto, nombre, descripcion, costo, precio_venta, cantidad_inventario, fecha_creacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(INSERT,
                productoDto.getId_producto(),
                productoDto.getNombre(),
                productoDto.getDescripcion(),
                productoDto.getCosto(),
                productoDto.getPrecio_venta(),
                productoDto.getCantidad_inventario(),
                productoDto.getFecha_creacion()
        );
        return;
    }

    @Override
    public List<Map<String, Object>> SeleccionarTodos() throws DaoExceptions {
        try {
            String SQL="SELECT id_producto, nombre, descripcion, costo, precio_venta, cantidad_inventario, fecha_creacion FROM productos";
            return  jdbcTemplate.queryForList(SQL);
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }
    }

    @Override
    public ProductoDto BuscarPorId(ProductoDto productoDto) throws DaoExceptions {
        try {
            String QUERY="SELECT id_producto, nombre, descripcion, costo, precio_venta, cantidad_inventario, fecha_creacion FROM public.productos WHERE id_producto=?";
            return  jdbcTemplate.queryForObject(QUERY,new ProductoMapper(),productoDto.getId_producto());
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public void Actualizar(ProductoDto productoDto) throws DaoExceptions {
        try {
            String UPDATE="UPDATE productos SET  nombre=?, descripcion=?, costo=?, precio_venta=?, cantidad_inventario=?, fecha_creacion=? WHERE  id_producto=?";
            jdbcTemplate.update(UPDATE,
                    productoDto.getNombre(),
                    productoDto.getDescripcion(),
                    productoDto.getCosto(),
                    productoDto.getPrecio_venta(),
                    productoDto.getCantidad_inventario(),
                    productoDto.getFecha_creacion(),
                    productoDto.getId_producto());
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

        return;
    }

    @Override
    public void Eliminar(ProductoDto productoDto) throws DaoExceptions {
        String DELETE = "DELETE FROM productos WHERE id_producto=?";
        try {
            jdbcTemplate.update(DELETE, productoDto.getId_producto());
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

        return;
    }
}
