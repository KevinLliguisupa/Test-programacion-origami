package com.restapi.facturacion_backend.business.dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProductoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long proId;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    private BigDecimal stock;

    private Boolean estado;

}
