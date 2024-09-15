package com.kurazao.kurazao.manager;

import com.kurazao.kurazao.dao.ProductoDaoInterface;
import com.kurazao.kurazao.dao.VentasDaoInterface;
import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.dto.VentasDto;
import com.kurazao.kurazao.exceptions.DaoExceptions;
import com.kurazao.kurazao.exceptions.ManagerExceptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public class VentaManagerImplements implements  VentaManagerInterface{
    public VentasDaoInterface ventasDaoInterface;
    public VentaManagerImplements(VentasDaoInterface ventasDaoInterface){
        this.ventasDaoInterface=ventasDaoInterface;
    }
    @Override
    public void GuardarOActualizar(VentasDto ventasDto) throws ManagerExceptions {
        try {
            VentasDto ventasFound = this.ventasDaoInterface.BuscarPorId(ventasDto);
            if (ventasFound==null){
                this.ventasDaoInterface.Insertar(ventasDto);
            }else{
                this.ventasDaoInterface.Actualizar(ventasDto);
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
            return this.ventasDaoInterface.SeleccionarTodos();
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
    }

    @Override
    public VentasDto BuscarPorId(VentasDto ventasDto) throws ManagerExceptions {
        VentasDto ventasFound= null;
        try {
            ventasFound= this.ventasDaoInterface.BuscarPorId(ventasDto);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
        return ventasFound;
    }

    @Override
    public void Actualizar(VentasDto ventasDto) throws ManagerExceptions {

    }

    @Override
    public void Eliminar(VentasDto ventasDto) throws ManagerExceptions {
        try {
            this.ventasDaoInterface.Eliminar(ventasDto);
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
    }

}
