package com.kurazao.kurazao.business;

import com.kurazao.kurazao.dto.InventarioDto;
import com.kurazao.kurazao.exceptions.BusinessExceptions;
import com.kurazao.kurazao.exceptions.ManagerExceptions;

import com.kurazao.kurazao.manager.ManagerInventarioInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Component

public class BusinessInventarioImplements implements BusinessInventarioInterface {
    private ManagerInventarioInterface managerInventarioInterface;

    public BusinessInventarioImplements(ManagerInventarioInterface managerInventarioInterface) {
        this.managerInventarioInterface = managerInventarioInterface;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void GuardarOActualizar(InventarioDto inventarioDto) throws BusinessExceptions {
        try {
            this.managerInventarioInterface.GuardarOActualizar(inventarioDto);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }



    @Transactional(readOnly = true)
    public List<Map<String, Object>> SeleccionarTodos() throws BusinessExceptions {
        try {
            return  this.managerInventarioInterface.SeleccionarTodos();
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(readOnly = true)
    public InventarioDto BuscarPorId(InventarioDto inventarioDto) throws BusinessExceptions {
        try {
            return this.managerInventarioInterface.BuscarPorId(inventarioDto);
        } catch (ManagerExceptions ex) {
            throw new BusinessExceptions(ex);
        } catch (Exception ex) {
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void Eliminar(InventarioDto inventarioDto) throws BusinessExceptions {
        try {
            this.managerInventarioInterface.Eliminar(inventarioDto);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }

    }
}
