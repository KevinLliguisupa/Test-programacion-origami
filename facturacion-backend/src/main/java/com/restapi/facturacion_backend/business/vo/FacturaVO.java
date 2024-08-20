package com.restapi.facturacion_backend.business.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class FacturaVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "cliId can not null")
    private Long cliId;

    @NotNull(message = "fechaEmision can not null")
    private String fechaEmision;

    @NotNull(message = "total can not null")
    private BigDecimal total;

    @NotNull(message = "estadoPago can not null")
    private String estadoPago;

    @NotNull(message = "detalles can not null")
    private List<FacturaDetalleVO> facturaDetalles;
}
