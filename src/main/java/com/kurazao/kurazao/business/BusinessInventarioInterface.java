package com.kurazao.kurazao.business;

import com.kurazao.kurazao.dto.GastoDto;
import com.kurazao.kurazao.dto.InventarioDto;
import com.kurazao.kurazao.exceptions.BusinessExceptions;

import java.util.List;
import java.util.Map;

public interface BusinessInventarioInterface {
    public void GuardarOActualizar(InventarioDto inventarioDto)  throws BusinessExceptions;

    public List<Map<String,Object>> SeleccionarTodos() throws BusinessExceptions;
    InventarioDto BuscarPorId(InventarioDto inventarioDto) throws BusinessExceptions;

    void Eliminar(InventarioDto inventarioDto) throws BusinessExceptions;
}
