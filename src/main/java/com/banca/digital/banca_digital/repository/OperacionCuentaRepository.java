package com.banca.digital.banca_digital.repository;

import com.banca.digital.banca_digital.entities.OperacionCuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperacionCuentaRepository extends JpaRepository<OperacionCuenta,String> {


    List<OperacionCuenta> findByCuentaBancariaId(String cuentaId);
}
