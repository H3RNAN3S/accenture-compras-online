package com.accenture.development.software.accenturecomprasonline.app.model.service;


import com.accenture.development.software.accenturecomprasonline.app.model.entity.Cliente;

import java.util.List;
import java.util.Map;

public interface IClienteService {

    List<Cliente> buscarClientes();

    Map<String, Object> buscarClientePorId(Long id);

    Map<String, Object> guardarCliente(Cliente cliente);

    Map<String, Object> eliminarCliente(Long id);

    Cliente cliente(Long id);
}
