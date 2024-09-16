package com.banca.digital.banca_digital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperacionCuenta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    private Date fechaOperacion;

    private double monto;


    @ManyToOne
    private CuentaBancaria cuentaBancaria;

    @OneToMany(mappedBy = "cuentaBancaria")  //esto significa que  viene de la clase padre o principal
    private List<OperacionCuenta> operacionCuentas;
}
