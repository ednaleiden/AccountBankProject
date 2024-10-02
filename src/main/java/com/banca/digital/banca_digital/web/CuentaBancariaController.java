package com.banca.digital.banca_digital.web;

import com.banca.digital.banca_digital.DTO.CuentaAhorroDTO;
import com.banca.digital.banca_digital.DTO.CuentaBancariaDTO;
import com.banca.digital.banca_digital.DTO.HistorialCuentaDTO;
import com.banca.digital.banca_digital.DTO.OperacionCuentaDTO;
import com.banca.digital.banca_digital.exceptions.CuentaBancariaNotFoundException;
import com.banca.digital.banca_digital.services.CuentaBancariaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<CuentaBancariaDTO> listarCuentasBancariasi(){
    return cuentaBancariaServices.listCuentaBancaria();
    }

    @GetMapping("/cuentas/{cuentaId}/operaciones")
    public List<OperacionCuentaDTO> listHistorialDeCuentas(@PathVariable String cuentaId){
        return cuentaBancariaServices.listHistorialDeCuentas(cuentaId);
    }

    @GetMapping("/cuentas/{cuentaId}/pageOperaciones")
    public HistorialCuentaDTO listHistorialDeCuentaPagina(@PathVariable String cuentaId, @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "5") int size) throws CuentaBancariaNotFoundException {
        return cuentaBancariaServices.getHistorialCuenta(cuentaId,page,size);
    }
}
