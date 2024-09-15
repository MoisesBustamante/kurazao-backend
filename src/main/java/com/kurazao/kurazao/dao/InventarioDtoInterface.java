package com.kurazao.kurazao.dao;

import com.kurazao.kurazao.dto.GastoDto;
import com.kurazao.kurazao.dto.InventarioDto;
import com.kurazao.kurazao.exceptions.DaoExceptions;

import java.util.List;
import java.util.Map;

public interface InventarioDtoInterface {
    void Insertar(InventarioDto inventarioDto) throws DaoExceptions;

    public List<Map<String,Object>> SeleccionarTodos()throws DaoExceptions;
    InventarioDto  BuscarPorId(InventarioDto inventarioDto)throws DaoExceptions;
    void Actualizar(InventarioDto inventarioDto)throws DaoExceptions;
    void Eliminar(InventarioDto inventarioDto)throws DaoExceptions;
}
