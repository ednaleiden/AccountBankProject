package com.banca.digital.banca_digital.repository;

import com.banca.digital.banca_digital.entities.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, String> {
}
