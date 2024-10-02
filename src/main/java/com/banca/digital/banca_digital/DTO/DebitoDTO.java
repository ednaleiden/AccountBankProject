package com.banca.digital.banca_digital.DTO;

import lombok.Data;

@Data
public class DebitoDTO {

    private String cuentaId;

    private double monto;

    private String descripcion;
}

