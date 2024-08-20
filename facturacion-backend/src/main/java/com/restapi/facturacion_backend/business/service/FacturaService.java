package com.restapi.facturacion_backend.business.service;

import com.restapi.facturacion_backend.business.dto.FacturaDTO;
import com.restapi.facturacion_backend.business.vo.FacturaDetalleVO;
import com.restapi.facturacion_backend.business.vo.FacturaUpdateVO;
import com.restapi.facturacion_backend.business.vo.FacturaVO;
import com.restapi.facturacion_backend.persistence.entity.Cliente;
import com.restapi.facturacion_backend.persistence.entity.Factura;
import com.restapi.facturacion_backend.persistence.entity.FacturaDetalle;
import com.restapi.facturacion_backend.persistence.entity.Producto;
import com.restapi.facturacion_backend.persistence.mapper.FacturaDetalleMapper;
import com.restapi.facturacion_backend.persistence.mapper.FacturaMapper;
import com.restapi.facturacion_backend.persistence.repository.FacturaDetalleRepository;
import com.restapi.facturacion_backend.persistence.repository.FacturaRepository;
import com.restapi.facturacion_backend.presentation.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private FacturaMapper facturaMapper;
    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;
    @Autowired
    private FacturaDetalleMapper facturaDetalleMapper;

    public Long obtenerSiguienteNumero(){
        return facturaRepository.findMaxNumero() + 1;
    }

    public List<FacturaDTO> obtenerFacturas(){
        List<Factura> facturas = facturaRepository.findAllByOrderByNumeroAsc();

        return facturaMapper.toDto(facturas);
    }

    public FacturaDTO obtenerPorId(Long facturaId){
        Factura factura = requireOne(facturaId);
        FacturaDTO facturaDto = facturaMapper.toDto(factura);
        facturaDto.setFacturaDetalles(facturaDetalleMapper.toDto(factura.getFacturaDetalles()));

        return facturaDto;
    }

    public FacturaDTO registrarFactura(FacturaVO nuevaFactura) {
        Factura facturaPorCrear = new Factura();

        //copiar los atributos que posee VO
        BeanUtils.copyProperties(nuevaFactura, facturaPorCrear);
        facturaPorCrear.setNumero(obtenerSiguienteNumero());
        facturaPorCrear.setCli(new Cliente(nuevaFactura.getCliId()));
        // Format String dates to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        facturaPorCrear.setFechaEmision(LocalDate.parse(nuevaFactura.getFechaEmision(), formatter));

        Factura facturaCreada = facturaRepository.save(facturaPorCrear);

        // En caso de existir detalles los registra
        if (!nuevaFactura.getFacturaDetalles().isEmpty()){
            crearFacturaDetalles(nuevaFactura.getFacturaDetalles(), facturaCreada);
        }

        return facturaMapper.toDto(facturaCreada);
    }

    public FacturaDTO actualizarFactura(Long facturaId, FacturaUpdateVO facturaActualizada) {
        Factura facturaRecuperada = requireOne(facturaId);

        //copiar los atributos que posee UpdateVO
        facturaRecuperada.setTotal(facturaActualizada.getTotal());
        facturaRecuperada.setEstadoPago(facturaActualizada.getEstadoPago());

        Factura facturaGuardada = facturaRepository.save(facturaRecuperada);

        // En caso de existir detalles los registra
        if (!facturaActualizada.getFacturaDetalles().isEmpty()){
            // Se elimina todos los detalles ya existentes
            facturaDetalleRepository.deleteAll(facturaGuardada.getFacturaDetalles());
            // Se crea los detalles actualizados
            crearFacturaDetalles(facturaActualizada.getFacturaDetalles(), facturaGuardada);
        }

        return facturaMapper.toDto(facturaGuardada);
    }

    private void crearFacturaDetalles(List<FacturaDetalleVO> detallesVo, Factura facturaCreada) {
        for (FacturaDetalleVO detalleVo : detallesVo) {
            FacturaDetalle facturaDetalle = new FacturaDetalle();
            facturaDetalle.setFac(facturaCreada);
            facturaDetalle.setCantidad(detalleVo.getCantidad());
            facturaDetalle.setPro(new Producto(detalleVo.getProId()));
            facturaDetalle.setPrecioUnitario(detalleVo.getPrecioUnitario());

            facturaDetalleRepository.save(facturaDetalle);
        }
    }

    private Factura requireOne(Long id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Factura con id: " + id + " no encontrado"));
    }
}
