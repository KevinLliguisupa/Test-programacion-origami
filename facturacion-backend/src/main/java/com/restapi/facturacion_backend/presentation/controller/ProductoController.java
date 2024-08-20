package com.restapi.facturacion_backend.presentation.controller;

import com.restapi.facturacion_backend.business.service.ProductoService;
import com.restapi.facturacion_backend.business.vo.ProductoVO;
import com.restapi.facturacion_backend.presentation.util.handler.ResponseHandler;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listar-todos")
    public ResponseEntity<Object> obtenerProductos() {
        return ResponseHandler.generateResponse(HttpStatus.OK, productoService.obtenerProductos());
    }

    @PostMapping("/registrar")
    public ResponseEntity<Object> registrarProducto(@Valid @RequestBody ProductoVO nuevoProducto) {
        return ResponseHandler.generateResponse("Producto registrado correctamente", HttpStatus.CREATED,
                productoService.registrarProducto(nuevoProducto));
    }

    @PutMapping("/actualizar/{productoId}")
    public ResponseEntity<Object> actualizarProducto(@Valid @RequestBody ProductoVO productoActualizado,
                                                     @Valid @NotNull @PathVariable("productoId") Long productoId) {
        return ResponseHandler.generateResponse(HttpStatus.OK, productoService.actualizarProducto(productoId,productoActualizado));
    }

    @PutMapping("/cambiar-estado/{productoId}")
    public ResponseEntity<Object> cambiarEstado(@Valid @NotNull @PathVariable("productoId") Long productoId) {
        return ResponseHandler.generateResponse(HttpStatus.OK, productoService.cambioEstado(productoId));
    }
}
