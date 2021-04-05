package com.accenture.development.software.accenturecomprasonline.app.controllers;


import com.accenture.development.software.accenturecomprasonline.app.model.entity.Pedido;
import com.accenture.development.software.accenturecomprasonline.app.model.service.IPedidoService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {})
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private IPedidoService pedidoService;

    public PedidoController(IPedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /**
     * Dado un cliente con la cedula de ciudadanía 12345 y con la dirección carrera 11# 14-08, cuando el cliente
     * selecciona los productos a comprar con un valor de más de 70 mil pesos entonces el sistema genera la factura
     * con el iva y el valor del domicilio.
     *
     * • Dado un cliente con la cedula de ciudadanía 12345 y con la dirección carrera 11# 14-08, cuando el cliente
     * selecciona los productos a comprar con un valor de más de 100 mil pesos entonces el sistema genera la factura
     * con el iva y el valor del domicilio en 0 pesos.
     *
     * Pasa los debidos argumentos a la capa de negocio para insertar
     * el pedido en la base de datos y generar la factura.
     * @param pedido objeto Pedido.
     * @param idProducto ids de los objetos Producto pasados por la url.
     * @param cantidad cantidades de los objetos Producto pasados por la url.
     * @return el objeto model.
     */
    @PostMapping("")
    public ResponseEntity<?> crearPedido(@RequestBody Pedido pedido,
                                         @RequestParam(value = "ids") Long[] idProducto,
                                         @RequestParam(value = "cantidad") Integer[] cantidad){

        Map<String, Object> model = new LinkedHashMap<>();
        try {
            model = pedidoService.generarFactura(pedido, idProducto, cantidad, model);
        }catch (DataAccessException e){
            model.put("mensaje", e.getMostSpecificCause().getMessage());
        }
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    /**
     *
     * @param pedido
     * @param idProducto
     * @param cantidad
     * @param model
     * @return
     */
    @PutMapping("")
    public ResponseEntity<Map<String, Object>> actualizarPedido(@RequestBody Pedido pedido,
                                                                @RequestParam Long[] idProducto,
                                                                @RequestParam  Integer[] cantidad,
                                                                Map<String, Object> model){
        try {
            model = pedidoService.actualizarFactura(pedido, idProducto, cantidad);
        }catch (DataAccessException e){
            model.put("mensaje", "Ocurrio un error de actualizacion");
            model.put("error", e.getMostSpecificCause().getMessage());
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @GetMapping("")
    public List<Pedido> obtenerPedidos(){
        return pedidoService.listaPedidos();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPedido(@PathVariable Long id, Map<String, Object> model){
        model = pedidoService.borrarPedidoPorId(id, model);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
