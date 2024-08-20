package com.restapi.facturacion_backend.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "factura")
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fac_id", nullable = false)
    private Long facId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cli_id", nullable = false)
    private Cliente cli;

    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "total", nullable = false, precision = 7, scale = 2)
    private BigDecimal total;

    @Column(name = "estado_pago", nullable = false, length = Integer.MAX_VALUE)
    private String estadoPago;

    @OneToMany(mappedBy = "fac")
    private List<FacturaDetalle> facturaDetalles = new ArrayList<>();

}