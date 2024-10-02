package com.banca.digital.banca_digital.repository;

import com.banca.digital.banca_digital.entities.CuentaBancaria;
import com.banca.digital.banca_digital.entities.OperacionCuenta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, String> {


}
