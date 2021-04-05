package com.accenture.development.software.accenturecomprasonline.app.model.dao;

import com.accenture.development.software.accenturecomprasonline.app.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
