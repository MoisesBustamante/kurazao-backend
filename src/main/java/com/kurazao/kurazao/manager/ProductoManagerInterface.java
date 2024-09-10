package com.kurazao.kurazao.manager;

import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.exceptions.ManagerExceptions;

import java.util.List;
import java.util.Map;

public interface ProductoManagerInterface {
    public void GuardarOActualizar(ProductoDto productoDto) throws ManagerExceptions;

    public List<Map<String,Object>> SeleccionarTodos()throws ManagerExceptions;
    ProductoDto BuscarPorId(ProductoDto productoDto)throws ManagerExceptions;
    void Actualizar(ProductoDto productoDto)throws ManagerExceptions;
    void Eliminar(ProductoDto  productoDto)throws ManagerExceptions;
}
