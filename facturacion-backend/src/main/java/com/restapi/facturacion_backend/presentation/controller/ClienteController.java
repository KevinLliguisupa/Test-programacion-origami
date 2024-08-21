package com.restapi.facturacion_backend.presentation.controller;

import com.restapi.facturacion_backend.business.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar-todos")
    public ResponseEntity<Object> obtenerClientes() {
        return ResponseEntity.ok(clienteService.obtenerClientes());
    }
}
