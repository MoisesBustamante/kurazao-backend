package com.kurazao.kurazao.manager;

import com.kurazao.kurazao.dao.GastoDaoInterface;
import com.kurazao.kurazao.dao.ProductoDaoInterface;
import com.kurazao.kurazao.dto.GastoDto;
import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.exceptions.DaoExceptions;
import com.kurazao.kurazao.exceptions.ManagerExceptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component

public class GastoManagerImplements implements  GastoManagerInterface{
    public GastoDaoInterface gastoDaoInterface;
    public GastoManagerImplements(GastoDaoInterface gastoDaoInterface){
        this.gastoDaoInterface=gastoDaoInterface;
    }
    @Override
    public void GuardarOActualizar(GastoDto gastoDto) throws ManagerExceptions {
        try {
            GastoDto ciudadesFound = this.gastoDaoInterface.BuscarPorId(gastoDto);
            if (ciudadesFound==null){
                this.gastoDaoInterface.Insertar(gastoDto);
            }else{
                this.gastoDaoInterface.Actualizar(gastoDto);
            }
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
    }

    @Override
    public List<Map<String, Object>> SeleccionarTodos() throws ManagerExceptions {
        try {
            return this.gastoDaoInterface.SeleccionarTodos();
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
    }

    @Override
    public GastoDto BuscarPorId(GastoDto gastoDto) throws ManagerExceptions {
        GastoDto ciudadesFound= null;
        try {
            ciudadesFound= this.gastoDaoInterface.BuscarPorId(gastoDto);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
        return ciudadesFound;
    }

    @Override
    public void Eliminar(GastoDto gastoDto) throws ManagerExceptions {
        try {
            this.gastoDaoInterface.Eliminar(gastoDto);
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
    }
    }

