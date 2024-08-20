package com.restapi.facturacion_backend.business.service;

import com.restapi.facturacion_backend.business.dto.ClienteDTO;
import com.restapi.facturacion_backend.persistence.entity.Cliente;
import com.restapi.facturacion_backend.persistence.mapper.ClienteMapper;
import com.restapi.facturacion_backend.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    public List<ClienteDTO> obtenerClientes(){
        List<Cliente> clientes = clienteRepository.findAllByOrderByNombresAsc();

        return clienteMapper.toDto(clientes);
    }
}
