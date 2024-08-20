package com.restapi.facturacion_backend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id", nullable = false)
    private Long cliId;

    @Column(name = "nombres", nullable = false, length = Integer.MAX_VALUE)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = Integer.MAX_VALUE)
    private String apellidos;

    @Column(name = "direccion", length = Integer.MAX_VALUE)
    private String direccion;

    @Column(name = "telefono", length = Integer.MAX_VALUE)
    private String telefono;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "estado", nullable = false)
    private Boolean estado = false;

    @OneToMany(mappedBy = "cli")
    private List<Factura> facturas = new ArrayList<>();

    public Cliente(Long cliId) {
        this.cliId = cliId;
    }
}