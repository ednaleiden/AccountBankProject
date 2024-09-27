package com.banca.digital.banca_digital.mapper;

import com.banca.digital.banca_digital.DTO.ClienteDTO;
import com.banca.digital.banca_digital.DTO.CuentaActualDTO;
import com.banca.digital.banca_digital.DTO.CuentaAhorroDTO;
import com.banca.digital.banca_digital.entities.Cliente;
import com.banca.digital.banca_digital.entities.CuentaActual;
import com.banca.digital.banca_digital.entities.CuentaAhorro;
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

    public CuentaAhorroDTO mapearDeCuentaAhorro(CuentaAhorro cuentaAhorro){
        CuentaAhorroDTO cuentaAhorroDTO = new CuentaAhorroDTO();
        BeanUtils.copyProperties(cuentaAhorro, cuentaAhorroDTO);
        cuentaAhorroDTO.setClienteDTO(mapperDeCliente(cuentaAhorro.getCliente()));
        cuentaAhorroDTO.setTipo(cuentaAhorro.getClass().getSimpleName());
        return cuentaAhorroDTO;
    }
    public CuentaAhorro mapearDeCuentaAhorroDTO(CuentaAhorroDTO cuentaAhorroDTO){
        CuentaAhorro cuentaAhorro = new CuentaAhorro();
        BeanUtils.copyProperties(cuentaAhorro, cuentaAhorroDTO);
        cuentaAhorroDTO.setClienteDTO(mapperDeCliente(cuentaAhorro.getCliente()));
        return cuentaAhorro;
    }
    public CuentaActualDTO mapearDeCuentaActual(CuentaActual cuentaActual){
        CuentaActualDTO cuentaActualDTO = new CuentaActualDTO();
        BeanUtils.copyProperties(cuentaActual, cuentaActualDTO);
        cuentaActualDTO.setClienteDTO(mapperDeCliente(cuentaActual.getCliente()));
        cuentaActualDTO.setTipo(cuentaActual.getClass().getSimpleName());
        return cuentaActualDTO;
    }
    public CuentaActual mapearDeCuentaActualDTO(CuentaActualDTO cuentaActualDTO){
        CuentaActual cuentaActual = new CuentaActual();
        BeanUtils.copyProperties(cuentaActual, cuentaActualDTO);
        cuentaActualDTO.setClienteDTO(mapperDeCliente(cuentaActual.getCliente()));
        return cuentaActual;
    }

}
