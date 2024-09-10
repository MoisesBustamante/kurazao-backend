package com.kurazao.kurazao.business;

import com.kurazao.kurazao.dto.GastoDto;
import com.kurazao.kurazao.exceptions.BusinessExceptions;
import com.kurazao.kurazao.exceptions.ManagerExceptions;
import com.kurazao.kurazao.manager.GastoManagerInterface;
import com.kurazao.kurazao.manager.ProductoManagerInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Component

public class BusinessGastoImplements implements  BusinessGastoInterface {
    private GastoManagerInterface gastoManagerInterface;
    public BusinessGastoImplements(GastoManagerInterface gastoManagerInterface){
        this.gastoManagerInterface=gastoManagerInterface;
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void GuardarOActualizar(GastoDto gastoDto) throws BusinessExceptions {
        try {
            this.gastoManagerInterface.GuardarOActualizar(gastoDto);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> SeleccionarTodos() throws BusinessExceptions {
        try {
            return  this.gastoManagerInterface.SeleccionarTodos();
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(readOnly = true)
    public GastoDto BuscarPorId(GastoDto gastoDto) throws BusinessExceptions {
        try {
            return this.gastoManagerInterface.BuscarPorId(gastoDto);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessExceptions.class)
    public void Eliminar(GastoDto gastoDto) throws BusinessExceptions {
        try {
            this.gastoManagerInterface.Eliminar(gastoDto);
        }catch (ManagerExceptions ex){
            throw new BusinessExceptions(ex);
        }catch (Exception ex){
            throw new BusinessExceptions(ex);
        }
    }
    }

