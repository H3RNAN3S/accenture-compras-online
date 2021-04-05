package com.accenture.development.software.accenturecomprasonline.app.controllers;


import com.accenture.development.software.accenturecomprasonline.app.model.entity.Factura;
import com.accenture.development.software.accenturecomprasonline.app.model.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;

    @GetMapping("")
    public List<Factura> obtenerFacturas(){
        return facturaService.listaFacturas();
    }
}
