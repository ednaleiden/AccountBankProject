package com.banca.digital.banca_digital.DTO;

import lombok.Data;

@Data
public class CreditoDTO {

    private String cuentaId;
    private double monto;

    private String descripcion;
}
