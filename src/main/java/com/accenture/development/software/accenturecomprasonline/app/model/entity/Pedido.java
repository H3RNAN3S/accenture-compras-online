package com.accenture.development.software.accenturecomprasonline.app.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

    public static final String NOMBRE_EMPRESA = "ACCENTURE";
    public static final Double VALOR_DOMICILIO = 25000.0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Cliente cliente;

    private Double servicioDomicilio;

    private Double costoPedido;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    @JsonIgnore
    private List<Factura> facturas;

    public Pedido(){
        this.facturas = new ArrayList<>();
    }

    public void agregarFactura(Factura factura){
        this.facturas.add(factura);
    }

    public Factura obtenerFactura(Long id){
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getId() == id ){
                return facturas.get(i);
            }
        }
        return null;
    }

    private static final long serialVersionUID = 1L;
}
