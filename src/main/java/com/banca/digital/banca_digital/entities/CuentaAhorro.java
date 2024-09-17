package com.banca.digital.banca_digital.entities;


import jakarta.persistence.Access;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("SA") //cuenta de ahorro
@NoArgsConstructor
@AllArgsConstructor
public class CuentaAhorro  extends CuentaBancaria{

    private double tasaInteres;
}
