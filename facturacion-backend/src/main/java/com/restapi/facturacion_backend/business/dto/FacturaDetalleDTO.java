package com.restapi.facturacion_backend.business.dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class FacturaDetalleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long detId;

    private Long facId;

    private Long proId;

    private BigDecimal cantidad;

    private BigDecimal precioUnitario;

}
