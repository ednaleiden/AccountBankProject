package com.banca.digital.banca_digital.services;

import com.banca.digital.banca_digital.entities.Cliente;
import com.banca.digital.banca_digital.entities.CuentaActual;
import com.banca.digital.banca_digital.entities.CuentaAhorro;
import com.banca.digital.banca_digital.entities.CuentaBancaria;
import com.banca.digital.banca_digital.exceptions.BalanceInsuficienteException;
import com.banca.digital.banca_digital.exceptions.ClienteNotFoundException;
import com.banca.digital.banca_digital.exceptions.CuentaBancariaNotFoundException;

import java.util.List;

public interface CuentaBancariaServices {

    Cliente saveCliente(Cliente cliente);



    CuentaActual saveCuentaBancariaActual(double balanceInicial, double sobregiro, Long clienteId) throws ClienteNotFoundException;

    CuentaAhorro saveCuentaBancariaAhorro(double balanceInicial, double tasaInteres, Long clienteId) throws ClienteNotFoundException;

    List<Cliente> listClientes();

    CuentaBancaria getCuentaBancaria(String cuentaId) throws CuentaBancariaNotFoundException;

    void debit(String cuentaId, double monto, String descripcion) throws CuentaBancariaNotFoundException, BalanceInsuficienteException;

    void credit(String cuentaId,double monto,String descripcion)throws CuentaBancariaNotFoundException;

    void transfer(String cuentaIdPropietario, String cuentaIdDestinatario , double monto) throws CuentaBancariaNotFoundException, BalanceInsuficienteException;

    List<CuentaBancaria> listCuentaBancaria();
}
