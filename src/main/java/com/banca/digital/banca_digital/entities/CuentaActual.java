package com.banca.digital.banca_digital.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@DiscriminatorValue("CA") // Cuenta actual
@AllArgsConstructor
@NoArgsConstructor
public class CuentaActual  extends  CuentaBancaria{

    private double sobregiro;
}
