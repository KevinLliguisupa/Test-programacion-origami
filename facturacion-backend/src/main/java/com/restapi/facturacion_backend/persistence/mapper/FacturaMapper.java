package com.restapi.facturacion_backend.persistence.mapper;

import com.restapi.facturacion_backend.business.dto.FacturaDTO;
import com.restapi.facturacion_backend.persistence.entity.Factura;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacturaMapper {
    @Mapping(target = "cliId", source = "entity.cli.cliId")
    FacturaDTO toDto(Factura entity);
    Factura toEntity(FacturaDTO dto);
    List<FacturaDTO> toDto(List<Factura> entities);
}
