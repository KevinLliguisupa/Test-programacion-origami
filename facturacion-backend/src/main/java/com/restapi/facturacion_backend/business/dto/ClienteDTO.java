package com.restapi.facturacion_backend.business.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cliId;

    private String nombres;

    private String apellidos;

    private String direccion;

    private String telefono;

    private String email;

    private Boolean estado;

}
