package com.accenture.development.software.accenturecomprasonline.app.model.dao;

import com.accenture.development.software.accenturecomprasonline.app.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    /**
     * Dado un cliente con la cedula de ciudadanía 12345 y con la dirección carrera 11# 14-08
     * se consulta la base de datos para hallar el cliente dueño del pedido.
     *
     * @param cedula campo del objeto Cliente.
     * @param direccion campo del objeto Cliente.
     * @return Un registro proveniente de la tabla clientes.
     */
    Cliente findByCedulaAndDireccion(String cedula, String direccion);

    Cliente findByCedula(String cedula);
}
