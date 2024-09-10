package com.kurazao.kurazao.manager;

import com.kurazao.kurazao.dto.GastoDto;
import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.exceptions.ManagerExceptions;

import java.util.List;
import java.util.Map;

public interface GastoManagerInterface {
    public void GuardarOActualizar(GastoDto gastoDto ) throws ManagerExceptions;

    public List<Map<String,Object>> SeleccionarTodos()throws ManagerExceptions;
    GastoDto BuscarPorId(GastoDto gastoDto)throws ManagerExceptions;

    void Eliminar(GastoDto gastoDto)throws ManagerExceptions;
}
