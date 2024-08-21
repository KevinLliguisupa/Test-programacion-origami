package com.restapi.facturacion_backend.business.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "cliId can not null")
    private Long cliId;

    @NotNull(message = "nombres can not null")
    private String nombres;

    @NotNull(message = "apellidos can not null")
    private String apellidos;

    @NotNull(message = "cedula can not null")
    private String cedula;

    private String direccion;

    private String telefono;

    private String email;

    @NotNull(message = "estado can not null")
    private Boolean estado;

}
