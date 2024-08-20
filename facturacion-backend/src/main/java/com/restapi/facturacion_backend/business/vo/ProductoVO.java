package com.restapi.facturacion_backend.business.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProductoVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "nombre can not null")
    private String nombre;

    private String descripcion;

    @NotNull(message = "precio can not null")
    private BigDecimal precio;

    @NotNull(message = "stock can not null")
    private BigDecimal stock;

    @NotNull(message = "estado can not null")
    private Boolean estado;

}
