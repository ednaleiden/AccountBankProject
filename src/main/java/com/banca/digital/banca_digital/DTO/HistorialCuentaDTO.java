package com.banca.digital.banca_digital.DTO;

import lombok.Data;

import java.util.List;

@Data
public class HistorialCuentaDTO {

    private String cuentaId;
    private  double balance;

    private int currentPage;

    private int totalPage;

    private int pageSize;

    private List<OperacionCuentaDTO> operacionCuentaDTOS;

}
