package com.restapi.facturacion_backend.persistence.repository;

import com.restapi.facturacion_backend.persistence.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long>, JpaSpecificationExecutor<Factura> {
    @Query("SELECT COALESCE(MAX(f.numero), 0) FROM Factura f")
    Long findMaxNumero();

    List<Factura> findAllByOrderByNumeroAsc();
}