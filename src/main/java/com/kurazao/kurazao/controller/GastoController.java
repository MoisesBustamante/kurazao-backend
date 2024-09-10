package com.kurazao.kurazao.controller;

import com.kurazao.kurazao.business.BusinessGastoInterface;
import com.kurazao.kurazao.dto.GastoDto;
import com.kurazao.kurazao.mensajes.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/gastos/")

public class GastoController {
    private BusinessGastoInterface businessGastoInterface;
    public GastoController(BusinessGastoInterface businessGastoInterfacee){
        this.businessGastoInterface=businessGastoInterfacee;
    }
    @PostMapping({"/GuardarOActualizar"})
    public ResponseEntity<ResponseMessage<GastoDto>> saveOrUpdate(@RequestBody GastoDto request) {
        log.debug("REST request to saveOrUpdate Planilla : {}", request);
        ResponseMessage message =null;
        try{
            businessGastoInterface.GuardarOActualizar(request);
            message = new ResponseMessage<>(200, "saveOrUpdate, process successful ", request);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }


        return ResponseEntity.ok(message);
    }
    @PostMapping({"/BuscarPorId/{Id}"})
    public ResponseEntity<ResponseMessage<GastoDto>> findById(@RequestBody GastoDto request) {
        log.debug("REST request to saveOrUpdate Planilla : {}", request);
        ResponseMessage message =null;
        try{
            GastoDto  GastoDto= businessGastoInterface.BuscarPorId(request);

            message = new ResponseMessage<>(200, "findById, process successful ", GastoDto);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }


        return ResponseEntity.ok(message);
    }
    @GetMapping("/All")
    public ResponseEntity<ResponseMessage> selectAll() {
        List<Map<String, Object>> list = null;
        ResponseMessage message =null;


        try {
            list= this.businessGastoInterface.SeleccionarTodos();
            message = new ResponseMessage<>(200, "All, process successful ", list );
        }catch (Exception exception){
            message = new ResponseMessage<>(406, exception.getMessage(),null );
        }
        return ResponseEntity.ok(message);
    }
    @PostMapping({"/Eliminar"})
    public ResponseEntity<ResponseMessage<GastoDto>> delete(@RequestBody GastoDto request) {
        log.debug("REST request to Delete Persona : {}", request);
        ResponseMessage<GastoDto> message;

        try {
            // Llamar al servicio para eliminar la persona
            this.businessGastoInterface.Eliminar(request);

            // Crear un mensaje de respuesta exitoso
            message = new ResponseMessage<>(200, "Delete, process successful", request);
        } catch (DataIntegrityViolationException ex) {
            // Capturar excepciones relacionadas con la integridad referencial
            log.error("Data integrity violation: {}", ex.getMessage(), ex);
            message = new ResponseMessage<>(500, "No se puede eliminar la persona porque tiene datos relacionados.", null);
            return ResponseEntity.badRequest().body(message);
        } catch (Exception ex) {
            // Capturar cualquier otra excepción general
            log.error("Error general al eliminar la persona: {}", ex.getMessage(), ex);
            message = new ResponseMessage<>(500, "Error al procesar la solicitud", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }

        return ResponseEntity.ok(message);
    }
}
