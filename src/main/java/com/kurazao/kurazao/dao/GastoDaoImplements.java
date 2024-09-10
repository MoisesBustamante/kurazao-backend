package com.kurazao.kurazao.dao;

import com.kurazao.kurazao.dto.GastoDto;
import com.kurazao.kurazao.exceptions.DaoExceptions;
import com.kurazao.kurazao.mapper.GastoMapper;
import com.kurazao.kurazao.mapper.ProductoMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
@Repository
public class GastoDaoImplements implements  GastoDaoInterface{
    private JdbcTemplate jdbcTemplate;
    public GastoDaoImplements(DataSource dataSource){
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }
    @Override
    public void Insertar(GastoDto gastoDto) throws DaoExceptions {
        String INSERT="INSERT INTO gastos(descripcion, monto) VALUES (?, ?)";
        jdbcTemplate.update(INSERT,

                gastoDto.getDescripcion(),
                gastoDto.getMonto()

        );
        return;
    }

    @Override
    public List<Map<String, Object>> SeleccionarTodos() throws DaoExceptions {
        try {
            String SQL="SELECT id_gasto,descripcion, monto, fecha_gasto FROM gastos";
            return  jdbcTemplate.queryForList(SQL);
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }
    }

    @Override
    public GastoDto BuscarPorId(GastoDto gastoDto) throws DaoExceptions {
        try {
            String QUERY="SELECT id_gasto,descripcion, monto, fecha_gasto FROM gastos WHERE id_gasto=?";
            return  jdbcTemplate.queryForObject(QUERY,new GastoMapper(),gastoDto.getId_gasto());
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public void Actualizar(GastoDto gastoDto) throws DaoExceptions {
        try {
            String UPDATE="UPDATE gastos SET  descripcion=?, monto=? WHERE  id_gasto=?";
            jdbcTemplate.update(UPDATE,

                    gastoDto.getDescripcion(),
                    gastoDto.getMonto(),
                    gastoDto.getId_gasto());
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

        return;
    }

    @Override
    public void Eliminar(GastoDto gastoDto) throws DaoExceptions {
        String DELETE = "DELETE FROM gastos WHERE id_gasto=?";
        try {
            jdbcTemplate.update(DELETE, gastoDto.getId_gasto());
        }catch (DataAccessException ex){
            throw new DaoExceptions(ex);
        }catch (Exception ex){
            throw new DaoExceptions(ex);
        }

        return;
    }
    }

