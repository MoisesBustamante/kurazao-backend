package com.kurazao.kurazao.business;

import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.dto.VentasDto;
import com.kurazao.kurazao.exceptions.BusinessExceptions;

import java.util.List;
import java.util.Map;

public interface BusinessVentaInterface {
    public void GuardarOActualizar(VentasDto ventasDto)  throws BusinessExceptions;

    public List<Map<String,Object>> SeleccionarTodos() throws BusinessExceptions;
    VentasDto BuscarPorId(VentasDto ventasDto) throws BusinessExceptions;

    void Eliminar(VentasDto ventasDto) throws BusinessExceptions;
}
