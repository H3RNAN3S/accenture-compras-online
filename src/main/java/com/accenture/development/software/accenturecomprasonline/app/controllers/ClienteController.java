package com.accenture.development.software.accenturecomprasonline.app.controllers;

import com.accenture.development.software.accenturecomprasonline.app.model.entity.Cliente;
import com.accenture.development.software.accenturecomprasonline.app.model.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {""})
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    /**
     * Conecta con la capa de negocio para obtener
     * todos los clientes en la base de datos.
     * @return lista de registros del objeto clientes.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Cliente> listarClientes(){
        return clienteService.buscarClientes();
    }

    /**
     * Conecta con la capa de negocio para obtener un cliente
     * que se encuentra en la base de datos.
     * @param id valor que me permite encontrar un cliente especifico.
     * @return un registro del objeto Cliente.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>>  buscarCliente(@PathVariable Long id){
        return new ResponseEntity<>(clienteService.buscarClientePorId(id), HttpStatus.OK);
    }

    /**
     * Conecta con la capa de negocios para insertar un nuevo registro Cliente.
     * @param cliente obejeto Cliente.
     * @return respectivos mensajes segun el caso.
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> insertarCliente(@Valid @RequestBody Cliente cliente,
                                                               BindingResult result, Map<String, Object> model){

        if (result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(error -> "El campo '" + error.getField() + "' " + error.getDefaultMessage())
                    .collect(Collectors.toList());

            model.put("errors", errors);
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        model = clienteService.guardarCliente(cliente);

        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    /**
     * Conecta con la capa de negocios para actualizar un registro Cliente.
     * @param cliente objeto Cliente entidad.
     * @param result captura los errores de validación.
     * @param model objeto map para cargar clave valor.
     * @return los respectivos mensajes de exito o de error.
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarCliente(@Valid @RequestBody Cliente cliente,
                                               BindingResult result, Map<String, Object> model){
        if (result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(error -> "El campo '" + error.getField() + "' " + error.getDefaultMessage())
                    .collect(Collectors.toList());

            model.put("errors", errors);
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        model = clienteService.buscarClientePorId(cliente.getId());

        Cliente dbCliente = (Cliente) model.get("cliente");

        dbCliente.setNombre(cliente.getNombre());
        dbCliente.setApellido(cliente.getApellido());
        dbCliente.setCedula(cliente.getCedula());
        dbCliente.setDireccion(cliente.getDireccion());

        try {
            model = clienteService.guardarCliente(dbCliente);
        }catch (DataAccessException e){
            model.put("mensaje", "Ocurrio un error al actualizar el cliente en la base de datos");
            model.put("error", e. getMostSpecificCause().getMessage());
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    /**
     * Conecta con la capa de negocios para eliminar un registro Cliente.
     * @param id identificación del registro en la base de datos.
     * @param model objeto map para cargar clave valor.
     * @return los respectivos mensajes de exito o de error.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminarCliente(@PathVariable Long id, Map<String, Object> model){

        model = clienteService.eliminarCliente(id);
        if (model.containsKey("error")){
            return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
