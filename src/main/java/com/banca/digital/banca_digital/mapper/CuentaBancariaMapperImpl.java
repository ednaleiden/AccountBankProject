package com.banca.digital.banca_digital.mapper;

import com.banca.digital.banca_digital.DTO.ClienteDTO;
import com.banca.digital.banca_digital.entities.Cliente;
import com.banca.digital.banca_digital.services.CuentaBancariaServices;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaBancariaMapperImpl {


    //ENTIDAD A DTO
    public ClienteDTO mapperDeCliente(Cliente cliente){
        ClienteDTO clienteDTO =  new ClienteDTO();
        BeanUtils.copyProperties(cliente, clienteDTO);
        return clienteDTO;
    }

    //DTO A ENTIDAD
    public Cliente mapperDeClienteDTO(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        return cliente;
    }
}
