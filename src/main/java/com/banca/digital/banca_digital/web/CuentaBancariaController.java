package com.banca.digital.banca_digital.web;

import com.banca.digital.banca_digital.DTO.*;
import com.banca.digital.banca_digital.exceptions.BalanceInsuficienteException;
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

    @PostMapping("/cuentas/debito")
    public DebitoDTO realizarDebito(@RequestBody DebitoDTO debitoDTO) throws CuentaBancariaNotFoundException, BalanceInsuficienteException {
        cuentaBancariaServices.debit(debitoDTO.getCuentaId(), debitoDTO.getMonto(),debitoDTO.getDescripcion());
        return  debitoDTO;
    }

    @PostMapping("/cuentas/credito")
    public CreditoDTO realizarCredito(@RequestBody CreditoDTO creditoDTO) throws CuentaBancariaNotFoundException, BalanceInsuficienteException {
        cuentaBancariaServices.credit(creditoDTO.getCuentaId(),creditoDTO.getMonto(),creditoDTO.getDescripcion());
        return  creditoDTO;
    }

    @PostMapping("/cuentas/transferencia")
    public void realizarTransferencias(@RequestBody TransferenciaRequestDTO transferenciaRequestDTO) throws CuentaBancariaNotFoundException, BalanceInsuficienteException {
        cuentaBancariaServices.transfer(transferenciaRequestDTO.getCuentaPropietario(),transferenciaRequestDTO.getCuentaDestinatario(),transferenciaRequestDTO.getMonto());

    }
}
