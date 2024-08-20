package com.restapi.facturacion_backend.persistence.mapper;

import com.restapi.facturacion_backend.business.dto.ClienteDTO;
import com.restapi.facturacion_backend.persistence.entity.Cliente;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDto(Cliente entity);
    Cliente toEntity(ClienteDTO dto);
    List<ClienteDTO> toDto(List<Cliente> entities);
}
