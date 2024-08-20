package com.restapi.facturacion_backend.business.service;

import com.restapi.facturacion_backend.business.dto.ProductoDTO;
import com.restapi.facturacion_backend.business.vo.ProductoVO;
import com.restapi.facturacion_backend.persistence.entity.Producto;
import com.restapi.facturacion_backend.persistence.mapper.ProductoMapper;
import com.restapi.facturacion_backend.persistence.repository.ProductoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper productoMapper;

    public List<ProductoDTO> obtenerProductos(){
        List<Producto> productos = productoRepository.findAllByOrderByNombreAsc();

        return productoMapper.toDto(productos);
    }

    public ProductoDTO registrarProducto(ProductoVO nuevoProducto){
        Producto producto = productoMapper.toEntity(nuevoProducto);

        return productoMapper.toDto(productoRepository.save(producto));
    }

    public ProductoDTO actualizarProducto(Long productoId, ProductoVO productoActualizado){
        Producto producto = requireOne(productoId);
        BeanUtils.copyProperties(productoActualizado, producto);

        return productoMapper.toDto(productoRepository.save(producto));
    }

    public String cambioEstado(Long productoId){
        Producto producto = requireOne(productoId);
        producto.setEstado(!producto.getEstado());
        productoRepository.save(producto);

        return "Estado actualizado correctamente: " + producto.getEstado();
    }

    private Producto requireOne(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado" + id));
    }
}
