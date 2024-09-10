package com.kurazao.kurazao.business;

import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.exceptions.BusinessExceptions;
import com.kurazao.kurazao.exceptions.ManagerExceptions;
import com.kurazao.kurazao.manager.ProductoManagerInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Component

public class BusinessProductoImplements implements  BusinessProductoInterface{
    private ProductoManagerInterface productoManagerInterface;
    public BusinessProductoImplements(ProductoManagerInterface productoManagerInterface){
        this.productoManagerInterface=productoManagerInterface;
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void GuardarOActualizar(ProductoDto productoDto) throws BusinessExceptions {
        try {
            this.productoManagerInterface.GuardarOActualizar(productoDto);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> SeleccionarTodos() throws BusinessExceptions {
        try {
            return  this.productoManagerInterface.SeleccionarTodos();
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(readOnly = true)
    public ProductoDto BuscarPorId(ProductoDto productoDto) throws BusinessExceptions {
        try {
            return this.productoManagerInterface.BuscarPorId(productoDto);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Override
    public void Actualizar(ProductoDto productoDto) throws BusinessExceptions {

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void Eliminar(ProductoDto productoDto) throws BusinessExceptions {
        try {
            this.productoManagerInterface.Eliminar(productoDto);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }
}
