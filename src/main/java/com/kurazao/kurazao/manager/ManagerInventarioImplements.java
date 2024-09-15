package com.kurazao.kurazao.manager;


import com.kurazao.kurazao.dao.InventarioDtoInterface;


import com.kurazao.kurazao.dto.InventarioDto;
import com.kurazao.kurazao.exceptions.DaoExceptions;
import com.kurazao.kurazao.exceptions.ManagerExceptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component

public class ManagerInventarioImplements implements ManagerInventarioInterface{
    public InventarioDtoInterface inventarioDtoInterface;
    public ManagerInventarioImplements(InventarioDtoInterface inventarioDtoInterface){
        this.inventarioDtoInterface=inventarioDtoInterface;
    }
    @Override
    public void GuardarOActualizar(InventarioDto inventarioDto) throws ManagerExceptions {
        try {
            InventarioDto ciudadesFound = this.inventarioDtoInterface.BuscarPorId(inventarioDto);
            if (ciudadesFound==null){
                this.inventarioDtoInterface.Insertar(inventarioDto);
            }else{
                this.inventarioDtoInterface.Actualizar(inventarioDto);
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
            return this.inventarioDtoInterface.SeleccionarTodos();
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
    }

    @Override
    public InventarioDto BuscarPorId(InventarioDto inventarioDto) throws ManagerExceptions {
        InventarioDto ciudadesFound= null;
        try {
            ciudadesFound= this.inventarioDtoInterface.BuscarPorId(inventarioDto);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
        return ciudadesFound;
    }

    @Override
    public void Eliminar(InventarioDto inventarioDto) throws ManagerExceptions {
        try {
            this.inventarioDtoInterface.Eliminar(inventarioDto);
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }

    }
}
