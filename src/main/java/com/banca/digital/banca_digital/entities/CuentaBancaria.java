package com.banca.digital.banca_digital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // herencia
@DiscriminatorColumn(name = "TIPO", length = 4) //
public class CuentaBancaria {

    @Id
    private String id;

    private  double balance;

    private Date fechaCreacion;

    @ManyToOne
    private Cliente cliente;
}
