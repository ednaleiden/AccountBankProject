package com.banca.digital.banca_digital.repository;

import com.banca.digital.banca_digital.entities.OperacionCuenta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperacionCuentaRepository extends JpaRepository<OperacionCuenta,String> {


    List<OperacionCuenta> findByCuentaBancariaId(String cuentaId);

    Page<OperacionCuenta> findByCuentaBancariaId(String cuentaId, Pageable pageable);
    Page<OperacionCuenta> findByCuentaBancariaIdOrderByFechaOperacionDesc(String cuentaId, Pageable pageable);
}
