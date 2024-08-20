package com.restapi.facturacion_backend.persistence.mapper;

import com.restapi.facturacion_backend.business.dto.ProductoDTO;
import com.restapi.facturacion_backend.business.vo.ProductoVO;
import com.restapi.facturacion_backend.persistence.entity.Producto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoDTO toDto(Producto entity);
    Producto toEntity(ProductoDTO dto);
    List<ProductoDTO> toDto(List<Producto> entities);
    Producto toEntity(ProductoVO vo);
}
