package com.banca.digital.banca_digital.DTO;

import com.banca.digital.banca_digital.enums.TipoOperacion;
import lombok.Data;

@Data
public class OperacionCuentaDTO {

    private Long id;
    private Data fechaOperacion;
    private double monto;
    private TipoOperacion TipoOperacion;
    private String descripcion;
}
