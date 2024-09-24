package com.banca.digital.banca_digital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //new informed


    private String nombre;

    private String email;

    //un cliente tiene muchas cuentas bancarias
    @OneToMany(mappedBy = "cliente")
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//PARA QUE NO RETORNE TODA LA LISTA SI NO SOLO ESCRITURA
    private List<CuentaBancaria> cuentaBancaria;
}
