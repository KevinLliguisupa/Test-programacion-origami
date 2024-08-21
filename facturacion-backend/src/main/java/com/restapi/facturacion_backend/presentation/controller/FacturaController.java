package com.restapi.facturacion_backend.presentation.controller;

import com.restapi.facturacion_backend.business.service.FacturaService;
import com.restapi.facturacion_backend.business.vo.FacturaUpdateVO;
import com.restapi.facturacion_backend.business.vo.FacturaVO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/siguiente-numero")
    public ResponseEntity<Object> obtenerNumero() {
        return ResponseEntity.ok(facturaService.obtenerSiguienteNumero());
    }

    @GetMapping("/listar-todas")
    public ResponseEntity<Object> obtenerFacturas() {
        return ResponseEntity.ok(facturaService.obtenerFacturas());
    }

    @GetMapping("/{facturaId}")
    public ResponseEntity<Object> obtenerPorId(@Valid @NotNull @PathVariable("facturaId") Long facturaId) {
        return ResponseEntity.ok(facturaService.obtenerPorId(facturaId));
    }

    @PostMapping("/registrar")
    public ResponseEntity<Object> registrarFactura(@Valid @RequestBody FacturaVO nuevaFactura) {
        return ResponseEntity.ok(facturaService.registrarFactura(nuevaFactura));
    }

    @PutMapping("/actualizar/{facturaId}")
    public ResponseEntity<Object> actualizarFactura(@Valid @NotNull @PathVariable("facturaId") Long facturaId,
                                                    @Valid @RequestBody FacturaUpdateVO facturaActualizada) {
        return ResponseEntity.ok(facturaService.actualizarFactura(facturaId, facturaActualizada));
    }
}
