package com.banca.digital.banca_digital.web;

import com.banca.digital.banca_digital.DTO.CuentaAhorroDTO;
import com.banca.digital.banca_digital.DTO.CuentaBancariaDTO;
import com.banca.digital.banca_digital.exceptions.CuentaBancariaNotFoundException;
import com.banca.digital.banca_digital.services.CuentaBancariaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CuentaBancariaController {


    @Autowired
    private CuentaBancariaServices cuentaBancariaServices;

    @GetMapping("/cuentas/{id}")
    public CuentaBancariaDTO listarDatosDeUnaCuentaBancaria(@PathVariable String id) throws CuentaBancariaNotFoundException {
    return  cuentaBancariaServices.getCuentaBancaria(id);
    }

    @GetMapping("/cuentas")
    public List<CuentaBancariaDTO> listarCuentasBancarias(){
    return cuentaBancariaServices.listCuentaBancaria();
    }
}
