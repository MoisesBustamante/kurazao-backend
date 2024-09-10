package com.kurazao.kurazao.business;

import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.exceptions.BusinessExceptions;


import java.util.List;
import java.util.Map;

public interface BusinessProductoInterface {
    public void GuardarOActualizar(ProductoDto productoDto)  throws BusinessExceptions;

    public List<Map<String,Object>> SeleccionarTodos() throws BusinessExceptions;
    ProductoDto BuscarPorId(ProductoDto productoDto) throws BusinessExceptions;
    void Actualizar(ProductoDto productoDto) throws BusinessExceptions;
    void Eliminar(ProductoDto  productoDto) throws BusinessExceptions;
}
