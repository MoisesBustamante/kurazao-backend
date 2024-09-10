package com.kurazao.kurazao.dao;

import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.exceptions.DaoExceptions;

import java.util.List;
import java.util.Map;

public interface ProductoDaoInterface {
    void Insertar(ProductoDto productoDto) throws DaoExceptions;

    public List<Map<String,Object>> SeleccionarTodos()throws DaoExceptions;
    ProductoDto BuscarPorId(ProductoDto productoDto)throws DaoExceptions;
    void Actualizar(ProductoDto productoDto)throws DaoExceptions;
    void Eliminar(ProductoDto  productoDto)throws DaoExceptions;
}
