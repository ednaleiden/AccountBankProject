package com.banca.digital.banca_digital.services;

import com.banca.digital.banca_digital.DTO.*;
import com.banca.digital.banca_digital.entities.Cliente;
import com.banca.digital.banca_digital.entities.CuentaActual;
import com.banca.digital.banca_digital.entities.CuentaAhorro;
import com.banca.digital.banca_digital.entities.CuentaBancaria;
import com.banca.digital.banca_digital.exceptions.BalanceInsuficienteException;
import com.banca.digital.banca_digital.exceptions.ClienteNotFoundException;
import com.banca.digital.banca_digital.exceptions.CuentaBancariaNotFoundException;

import java.util.List;

public interface CuentaBancariaServices {

    ClienteDTO saveCliente(ClienteDTO clienteDTO);

    ClienteDTO getCliente(Long clienteId) throws  ClienteNotFoundException;

    ClienteDTO updateCliente(ClienteDTO clienteDTO);

    List<ClienteDTO> searchClientes(String keyword);

    void deleteCliente(Long clienteId);

    CuentaActualDTO saveCuentaBancariaActual(double balanceInicial, double sobregiro, Long clienteId) throws ClienteNotFoundException;

    CuentaAhorroDTO saveCuentaBancariaAhorro(double balanceInicial, double tasaInteres, Long clienteId) throws ClienteNotFoundException;

    List<ClienteDTO> listClientes();

    CuentaBancariaDTO getCuentaBancaria(String cuentaId) throws CuentaBancariaNotFoundException;

    void debit(String cuentaId, double monto, String descripcion) throws CuentaBancariaNotFoundException, BalanceInsuficienteException;

    void credit(String cuentaId,double monto,String descripcion)throws CuentaBancariaNotFoundException;

    void transfer(String cuentaIdPropietario, String cuentaIdDestinatario , double monto) throws CuentaBancariaNotFoundException, BalanceInsuficienteException;

    List<CuentaBancariaDTO> listCuentaBancaria();

    List<OperacionCuentaDTO> listHistorialDeCuentas(String cuentaId);

    HistorialCuentaDTO getHistorialCuenta(String cuentaId , int page, int size) throws CuentaBancariaNotFoundException;
}
