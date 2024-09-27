package com.banca.digital.banca_digital.web;

import com.banca.digital.banca_digital.DTO.ClienteDTO;
import com.banca.digital.banca_digital.entities.Cliente;
import com.banca.digital.banca_digital.exceptions.ClienteNotFoundException;
import com.banca.digital.banca_digital.services.CuentaBancariaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private CuentaBancariaServices cuentaBancariaServices;

    @GetMapping("/clientes")
    public List<ClienteDTO> listarClientes(){
        return cuentaBancariaServices.listClientes();

    }

    @GetMapping("/cliente/{id}")
    public ClienteDTO listarDatosDelCliente(@PathVariable(name = "id") Long clienteId) throws ClienteNotFoundException{
    return cuentaBancariaServices.getCliente(clienteId);
    }

    @PostMapping("/clientes")
    public ClienteDTO guardarCliente(@RequestBody ClienteDTO clienteDTO){
        return cuentaBancariaServices.saveCliente(clienteDTO);
    }

    @PutMapping("/clientes/{clienteId}")
        public ClienteDTO actualizarCliente(@PathVariable Long clienteId,@RequestBody ClienteDTO clienteDTO){
    clienteDTO.setId(clienteId);
    return  cuentaBancariaServices.updateCliente(clienteDTO);
    }

    @DeleteMapping("/clientes/{id}")
    public void eliminarCliente(@PathVariable Long id){
        cuentaBancariaServices.deleteCliente(id);
    }
}
