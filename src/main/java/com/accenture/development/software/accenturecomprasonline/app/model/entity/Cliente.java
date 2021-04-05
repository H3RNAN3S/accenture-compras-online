package com.accenture.development.software.accenturecomprasonline.app.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = " no debe estar vacío")
    private String nombre;

    @NotEmpty(message = " no puede estar vacío")
    private String apellido;

    @NotEmpty(message = " no puede estar vacío")
    private String cedula;

    @NotEmpty(message = " no puede estar vacío")
    private String direccion;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creadoEn;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pedido> pedidos;

    public Cliente() {
        this.pedidos = new ArrayList<>();
    }

    @PrePersist
    public void prepersist(){
        this.creadoEn = LocalDate.now();
    }

    private static final long serialVersionUID = 1L;
}
