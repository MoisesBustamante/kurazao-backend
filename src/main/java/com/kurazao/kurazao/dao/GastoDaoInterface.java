package com.kurazao.kurazao.dao;

import com.kurazao.kurazao.dto.GastoDto;

import com.kurazao.kurazao.exceptions.DaoExceptions;

import java.util.List;
import java.util.Map;

public interface GastoDaoInterface {
    void Insertar(GastoDto gastoDto) throws DaoExceptions;

    public List<Map<String,Object>> SeleccionarTodos()throws DaoExceptions;
    GastoDto  BuscarPorId(GastoDto gastoDto)throws DaoExceptions;
    void Actualizar(GastoDto gastoDto)throws DaoExceptions;
    void Eliminar(GastoDto gastoDto)throws DaoExceptions;
}
