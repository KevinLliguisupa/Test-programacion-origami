package com.restapi.facturacion_backend.business.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class FacturaDetalleVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "proId can not null")
    private Long proId;

    @NotNull(message = "cantidad can not null")
    private BigDecimal cantidad;

    @NotNull(message = "precioUnitario can not null")
    private BigDecimal precioUnitario;

}
