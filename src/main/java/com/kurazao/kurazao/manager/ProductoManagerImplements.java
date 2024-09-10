package com.kurazao.kurazao.manager;

import com.kurazao.kurazao.dao.ProductoDaoInterface;
import com.kurazao.kurazao.dto.ProductoDto;
import com.kurazao.kurazao.exceptions.DaoExceptions;
import com.kurazao.kurazao.exceptions.ManagerExceptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component

public class ProductoManagerImplements implements  ProductoManagerInterface{
    public ProductoDaoInterface productoDaoInterface;
    public ProductoManagerImplements(ProductoDaoInterface productoDaoInterface){
        this.productoDaoInterface=productoDaoInterface;
    }
    @Override
    public void GuardarOActualizar(ProductoDto productoDto) throws ManagerExceptions {
        try {
            ProductoDto  ciudadesFound = this.productoDaoInterface.BuscarPorId(productoDto);
            if (ciudadesFound==null){
                this.productoDaoInterface.Insertar(productoDto);
            }else{
                this.productoDaoInterface.Actualizar(productoDto);
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
            return this.productoDaoInterface.SeleccionarTodos();
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
    }

    @Override
    public ProductoDto BuscarPorId(ProductoDto productoDto) throws ManagerExceptions {
        ProductoDto ciudadesFound= null;
        try {
            ciudadesFound= this.productoDaoInterface.BuscarPorId(productoDto);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
        return ciudadesFound;
    }

    @Override
    public void Actualizar(ProductoDto productoDto) throws ManagerExceptions {

    }

    @Override
    public void Eliminar(ProductoDto productoDto) throws ManagerExceptions {
        try {
            this.productoDaoInterface.Eliminar(productoDto);
        }catch (DaoExceptions ex){
            throw new ManagerExceptions(ex);
        }catch (Exception ex){
            throw new ManagerExceptions(ex);
        }
    }
}
