package com.restapi.facturacion_backend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id", nullable = false)
    private Long proId;

    @Column(name = "nombre", nullable = false, length = Integer.MAX_VALUE)
    private String nombre;

    @Column(name = "descripcion", length = Integer.MAX_VALUE)
    private String descripcion;

    @Column(name = "precio", nullable = false, precision = 7, scale = 2)
    private BigDecimal precio;

    @Column(name = "stock", nullable = false, precision = 10, scale = 3)
    private BigDecimal stock;

    @Column(name = "estado", nullable = false)
    private Boolean estado = false;

    @OneToMany(mappedBy = "pro")
    private Set<FacturaDetalle> facturaDetalles = new LinkedHashSet<>();

    public Producto(Long proId) {
        this.proId = proId;
    }
}