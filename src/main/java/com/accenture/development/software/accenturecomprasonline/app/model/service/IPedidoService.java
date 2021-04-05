package com.accenture.development.software.accenturecomprasonline.app.model.service;

import com.accenture.development.software.accenturecomprasonline.app.model.entity.Factura;
import com.accenture.development.software.accenturecomprasonline.app.model.entity.Pedido;


import java.util.List;
import java.util.Map;

public interface IPedidoService {

    Map<String, Object> generarFactura(Pedido pedido, Long[] idProductos, Integer[] cantidad, Map<String, Object> model);

    Map<String, Object> actualizarFactura(Pedido pedido, Long[] idProductos, Integer[] cantidad);

    List<Pedido> listaPedidos();

    Map<String, Object> borrarPedidoPorId(Long id, Map<String, Object> model);
}
