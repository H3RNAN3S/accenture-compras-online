package com.accenture.development.software.accenturecomprasonline.app.model.service;

import com.accenture.development.software.accenturecomprasonline.app.model.dao.ClienteRepository;
import com.accenture.development.software.accenturecomprasonline.app.model.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Obtiene todos los clientes asociados en la base de datos.
     * @return una lista de clientes.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }

    /**
     * Obtiene un cliente asociado en la base de datos.
     * @param id del cliente.
     * @return el cliente encontrado por su id.
     */
    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> buscarClientePorId(Long id) {
        Map<String, Object> model = new LinkedHashMap<>();
        if (!clienteRepository.existsById(id)){
            model.put("mensaje", "El Cliente con el id " + id + " no existe en la base de datos");
            return model;
        }
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        model.put("cliente", cliente);
        return model;
    }

    /**
     * Guarda el objeto Cliente en la base de datos.
     * @param cliente objeto Cliente.
     */
    @Override
    public Map<String, Object> guardarCliente(Cliente cliente) {
        Map<String, Object> model = new LinkedHashMap<>();
        try {
            clienteRepository.save(cliente);
        }catch (DataAccessException e){
            model.put("mensaje", "Ocurrio un error al insertar el cliente en la base de datos.");
            model.put("error", e.getMostSpecificCause().getMessage());
            return model;
        }
        model.put("mensaje", "El cliente fue insertado con éxito");
        return model;
    }

    /**
     * Elimina un registro por el id del cliente.
     * @param id identificación del registro Cliente.
     * @return mensajes respectivos segun sea el caso.
     */
    @Override
    public Map<String, Object> eliminarCliente(Long id) {
        Map<String, Object> model = new LinkedHashMap<>();

        if (!clienteRepository.existsById(id)){
            model.put("error", "El cliente con el id " + id + " no existe en la base de datos");
            return model;
        }
        clienteRepository.deleteById(id);
        model.put("mensaje", "El cliente ha sido eliminado con éxito");
        return model;
    }

    @Override
    public Cliente cliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

}
