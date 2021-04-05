package com.accenture.development.software.accenturecomprasonline.app.controllers;

import com.accenture.development.software.accenturecomprasonline.app.model.entity.Producto;
import com.accenture.development.software.accenturecomprasonline.app.model.service.IProductoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {""})
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Consulta todos productos existentes en la base de datos
     * necesarios para uso del cliente.
     * @return la lista de productos.
     */
    @GetMapping("")
    public List<Producto> listarProductos(){
        return productoService.obtenerProductos();
    }

}
