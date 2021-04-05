package com.accenture.development.software.accenturecomprasonline.app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombreProducto;

    @NotBlank
    private Double precio;

    @NotBlank
    @Column(name = "porcenta_iva")
    private Double iva;

    private static final long serialVersionUID = 1L;
}
