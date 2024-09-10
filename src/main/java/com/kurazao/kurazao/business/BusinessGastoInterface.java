package com.kurazao.kurazao.business;

import com.kurazao.kurazao.dto.GastoDto;
import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.exceptions.BusinessExceptions;

import java.util.List;
import java.util.Map;

public interface BusinessGastoInterface {
    public void GuardarOActualizar(GastoDto gastoDto)  throws BusinessExceptions;

    public List<Map<String,Object>> SeleccionarTodos() throws BusinessExceptions;
    GastoDto BuscarPorId(GastoDto gastoDto) throws BusinessExceptions;

    void Eliminar(GastoDto gastoDto) throws BusinessExceptions;

}
