package com.accenture.development.software.accenturecomprasonline.app.model.dao;

import com.accenture.development.software.accenturecomprasonline.app.model.entity.Factura;
import com.accenture.development.software.accenturecomprasonline.app.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

    /**
     * Consulta todos los registros asociados al id del pedido.
     * @param id del pedido.
     * @return lista de facturas.
     */
    @Query(value = "select * from facturas where pedido_id = ?1", nativeQuery = true)
    List<Factura> obtenerPedidoPorId(Long id);

    @Query(value = "select producto_id from facturas where pedido_id = ?1", nativeQuery = true)
    List<Long> obtenerProductosPorIdPedido(Long id);
}
