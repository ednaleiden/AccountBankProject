package com.banca.digital.banca_digital.web;

import com.banca.digital.banca_digital.DTO.ClienteDTO;
import com.banca.digital.banca_digital.entities.Cliente;
import com.banca.digital.banca_digital.services.CuentaBancariaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private CuentaBancariaServices cuentaBancariaServices;

    @GetMapping("/clientes")
    public List<ClienteDTO> listarClientes(){
        return cuentaBancariaServices.listClientes();

    }
}
