package com.accenture.development.software.accenturecomprasonline.app.model.dao;

import com.accenture.development.software.accenturecomprasonline.app.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
