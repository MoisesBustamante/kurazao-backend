package com.kurazao.kurazao.manager;

import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.dto.VentasDto;
import com.kurazao.kurazao.exceptions.ManagerExceptions;

import java.util.List;
import java.util.Map;

public interface VentaManagerInterface {

    public void GuardarOActualizar(VentasDto ventasDto) throws ManagerExceptions;

    public List<Map<String,Object>> SeleccionarTodos()throws ManagerExceptions;
    VentasDto BuscarPorId(VentasDto ventasDto)throws ManagerExceptions;
    void Actualizar(VentasDto ventasDto)throws ManagerExceptions;
    void Eliminar(VentasDto ventasDto)throws ManagerExceptions;
}
