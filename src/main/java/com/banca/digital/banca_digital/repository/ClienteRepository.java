package com.banca.digital.banca_digital.repository;

import com.banca.digital.banca_digital.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
