package com.restapi.facturacion_backend.persistence.mapper;

import com.restapi.facturacion_backend.business.dto.FacturaDetalleDTO;
import com.restapi.facturacion_backend.business.vo.FacturaDetalleVO;
import com.restapi.facturacion_backend.persistence.entity.FacturaDetalle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacturaDetalleMapper {
    FacturaDetalleDTO toDto(FacturaDetalle entity);
    FacturaDetalle toEntity(FacturaDetalleDTO dto);
    List<FacturaDetalleDTO> toDto(List<FacturaDetalle> entities);
    List<FacturaDetalle> voToEntity(List<FacturaDetalleVO> vos);
}
