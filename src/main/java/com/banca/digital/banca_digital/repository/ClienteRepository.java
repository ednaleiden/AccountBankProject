package com.banca.digital.banca_digital.repository;

import com.banca.digital.banca_digital.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Query("SELECT c FROM Cliente c where c.nombre LIKE :kw")
    List<Cliente> searchClientes(@Param(value = "kw") String keyword);
}
