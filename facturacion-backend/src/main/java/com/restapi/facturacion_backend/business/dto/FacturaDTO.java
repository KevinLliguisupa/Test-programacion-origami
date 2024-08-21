package com.restapi.facturacion_backend.business.dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
public class FacturaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long facId;

    private Long cliId;

    private Long numero;

    private Date fechaEmision;

    private BigDecimal total;

    private String observaciones;

    private String estadoPago;

    private List<FacturaDetalleDTO> facturaDetalles;

}
