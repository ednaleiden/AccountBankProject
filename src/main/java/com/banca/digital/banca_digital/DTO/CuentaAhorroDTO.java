package com.banca.digital.banca_digital.DTO;

import com.banca.digital.banca_digital.entities.CuentaBancaria;
import lombok.Data;

import java.util.Date;

@Data
public class CuentaAhorroDTO extends CuentaBancariaDTO {

    private String id;

    private double balance;

    private Date fechaCreacion;

    private ClienteDTO clienteDTO;

    private double tasaDeInteres;
}
