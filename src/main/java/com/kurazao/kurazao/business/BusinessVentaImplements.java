package com.kurazao.kurazao.business;

import com.kurazao.kurazao.dto.VentasDto;
import com.kurazao.kurazao.exceptions.BusinessExceptions;
import com.kurazao.kurazao.exceptions.ManagerExceptions;
import com.kurazao.kurazao.manager.ProductoManagerInterface;
import com.kurazao.kurazao.manager.VentaManagerInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component

public class BusinessVentaImplements implements  BusinessVentaInterface {
    private VentaManagerInterface ventaManagerInterface;
    public BusinessVentaImplements(VentaManagerInterface ventaManagerInterface){
        this.ventaManagerInterface=ventaManagerInterface;
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void GuardarOActualizar(VentasDto ventasDto) throws BusinessExceptions {
        try {
            this.ventaManagerInterface.GuardarOActualizar(ventasDto);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> SeleccionarTodos() throws BusinessExceptions {
        try {
            return  this.ventaManagerInterface.SeleccionarTodos();
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(readOnly = true)
    public VentasDto BuscarPorId(VentasDto ventasDto) throws BusinessExceptions {
        try {
            return this.ventaManagerInterface.BuscarPorId(ventasDto);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void Eliminar(VentasDto ventasDto) throws BusinessExceptions {
        try {
            this.ventaManagerInterface.Eliminar(ventasDto);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }
}
