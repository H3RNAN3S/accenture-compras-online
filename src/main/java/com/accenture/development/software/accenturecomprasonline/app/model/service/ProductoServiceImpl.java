package com.accenture.development.software.accenturecomprasonline.app.model.service;

import com.accenture.development.software.accenturecomprasonline.app.model.dao.ProductoRepository;
import com.accenture.development.software.accenturecomprasonline.app.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{

    private ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

}
