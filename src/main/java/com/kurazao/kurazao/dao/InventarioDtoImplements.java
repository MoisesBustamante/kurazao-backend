package com.kurazao.kurazao.dao;

import com.kurazao.kurazao.dto.InventarioDto;
import com.kurazao.kurazao.exceptions.DaoExceptions;
import com.kurazao.kurazao.mapper.InventarioMapper;
import com.kurazao.kurazao.mapper.ProductoMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
@Repository

public class InventarioDtoImplements implements InventarioDtoInterface {

    private JdbcTemplate jdbcTemplate;
    public InventarioDtoImplements(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
    @Override
    public void Insertar(InventarioDto inventarioDto) throws DaoExceptions {
        String INSERT="INSERT INTO inventario(id_producto, cantidad_agregada) VALUES (?, ?)";
        jdbcTemplate.update(INSERT,

                inventarioDto.getProductoDto().getId_producto(),
                inventarioDto.getCantidad()


        );
        return;

    }

    @Override
    public List<Map<String, Object>> SeleccionarTodos() throws DaoExceptions {
        try {
            String SQL="SELECT  id_inventario, id_producto, cantidad_agregada, fecha_actualizacion FROM inventario";
            return  jdbcTemplate.queryForList(SQL);
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }
    }

    @Override
    public InventarioDto BuscarPorId(InventarioDto inventarioDto) throws DaoExceptions {
        try {
            String QUERY="SELECT id_producto, nombre, descripcion, costo, precio_venta, cantidad_inventario, fecha_creacion FROM public.productos WHERE id_producto=?";
            return  jdbcTemplate.queryForObject(QUERY,new InventarioMapper(),inventarioDto.getId_inventario());
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public void Actualizar(InventarioDto inventarioDto) throws DaoExceptions {
        try {
            String UPDATE="UPDATE inventario SET id_producto, cantidad_agregada, fecha_actualizacion  WHERE  id_inventario=?";
            jdbcTemplate.update(UPDATE,
                    inventarioDto.getProductoDto().getId_producto(),
                    inventarioDto.getCantidad(),
                    inventarioDto.getFecha_actualizacion(),
                    inventarioDto.getId_inventario()
            );
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }
    }

    @Override
    public void Eliminar(InventarioDto inventarioDto) throws DaoExceptions {
        String DELETE = "DELETE FROM inventario WHERE id_inventario=?";
        try {
            jdbcTemplate.update(DELETE, inventarioDto.getId_inventario());
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

        return;
    }
}
