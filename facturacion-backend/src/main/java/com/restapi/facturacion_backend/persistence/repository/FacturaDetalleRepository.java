package com.restapi.facturacion_backend.persistence.repository;

import com.restapi.facturacion_backend.persistence.entity.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalle, Long>, JpaSpecificationExecutor<FacturaDetalle> {

}