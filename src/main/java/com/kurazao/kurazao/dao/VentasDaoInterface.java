package com.kurazao.kurazao.dao;

import com.kurazao.kurazao.dto.VentasDto;
import com.kurazao.kurazao.exceptions.DaoExceptions;

import java.util.List;
import java.util.Map;

public interface VentasDaoInterface {
    void Insertar(VentasDto ventasDto) throws DaoExceptions;

    public List<Map<String,Object>> SeleccionarTodos()throws DaoExceptions;
    VentasDto  BuscarPorId(VentasDto ventasDto)throws DaoExceptions;
    void Actualizar(VentasDto ventasDto)throws DaoExceptions;
    void Eliminar(VentasDto ventasDto)throws DaoExceptions;
}
