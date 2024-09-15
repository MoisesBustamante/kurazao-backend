package com.kurazao.kurazao.manager;

import com.kurazao.kurazao.dto.InventarioDto;
import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.exceptions.ManagerExceptions;

import java.util.List;
import java.util.Map;

public interface ManagerInventarioInterface {
    public void GuardarOActualizar(InventarioDto inventarioDto) throws ManagerExceptions;

    public List<Map<String,Object>> SeleccionarTodos()throws ManagerExceptions;
    InventarioDto BuscarPorId(InventarioDto inventarioDto)throws ManagerExceptions;

    void Eliminar(InventarioDto inventarioDto)throws ManagerExceptions;

}
