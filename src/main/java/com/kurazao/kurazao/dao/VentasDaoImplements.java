package com.kurazao.kurazao.dao;

import com.kurazao.kurazao.dto.VentasDto;
import com.kurazao.kurazao.exceptions.DaoExceptions;
import com.kurazao.kurazao.mapper.InventarioMapper;
import com.kurazao.kurazao.mapper.VentaMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
@Repository

public class VentasDaoImplements implements VentasDaoInterface{
    private JdbcTemplate jdbcTemplate;
    public VentasDaoImplements(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
    @Override
    public void Insertar(VentasDto ventasDto) throws DaoExceptions {
        String INSERT="INSERT INTO ventas(id_producto, cantidad, total) VALUES (?, ?, ?)";
        jdbcTemplate.update(INSERT,
                ventasDto.getProductoDto().getId_producto(),
                ventasDto.getCantidad(),
                ventasDto.getTotal()



        );
        return;
    }

    @Override
    public List<Map<String, Object>> SeleccionarTodos() throws DaoExceptions {
        try {
            String SQL="SELECT  id_venta, id_producto, cantidad,total, fecha_venta FROM ventas";
            return  jdbcTemplate.queryForList(SQL);
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }
    }

    @Override
    public VentasDto BuscarPorId(VentasDto ventasDto) throws DaoExceptions {
        try {
            String QUERY="SELECT id_producto, cantidad, total, fecha_venta FROM ventas WHERE id_venta=?";
            return  jdbcTemplate.queryForObject(QUERY,new VentaMapper(),ventasDto.getId_venta());
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public void Actualizar(VentasDto ventasDto) throws DaoExceptions {
        try {
            String UPDATE="UPDATE ventas SET id_producto, cantidad,total, fecha_venta  WHERE  id_venta=?";
            jdbcTemplate.update(UPDATE,
                    ventasDto.getProductoDto().getId_producto(),
                    ventasDto.getCantidad(),
                    ventasDto.getTotal(),
                    ventasDto.getFecha_venta(),
                    ventasDto.getId_venta()
            );
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }
    }

    @Override
    public void Eliminar(VentasDto ventasDto) throws DaoExceptions {
        String DELETE = "DELETE FROM ventas WHERE id_venta=?";
        try {
            jdbcTemplate.update(DELETE, ventasDto.getId_venta());
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

        return;
    }
    }

