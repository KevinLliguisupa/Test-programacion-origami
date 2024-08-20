package com.restapi.facturacion_backend.presentation.controller;

import com.restapi.facturacion_backend.business.service.ClienteService;
import com.restapi.facturacion_backend.presentation.util.handler.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar-todos")
    public ResponseEntity<Object> obtenerClientes() {
        return ResponseHandler.generateResponse(HttpStatus.OK, clienteService.obtenerClientes());
    }
}
