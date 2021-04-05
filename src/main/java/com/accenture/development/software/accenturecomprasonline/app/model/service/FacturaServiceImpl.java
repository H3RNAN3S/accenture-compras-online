package com.accenture.development.software.accenturecomprasonline.app.model.service;


import com.accenture.development.software.accenturecomprasonline.app.model.dao.FacturaRepository;
import com.accenture.development.software.accenturecomprasonline.app.model.entity.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements IFacturaService{

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> listaFacturas() {
        return facturaRepository.findAll();
    }
}
