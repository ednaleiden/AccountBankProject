package com.banca.digital.banca_digital;

import com.banca.digital.banca_digital.DTO.ClienteDTO;
import com.banca.digital.banca_digital.DTO.CuentaActualDTO;
import com.banca.digital.banca_digital.DTO.CuentaAhorroDTO;
import com.banca.digital.banca_digital.DTO.CuentaBancariaDTO;
import com.banca.digital.banca_digital.entities.*;
import com.banca.digital.banca_digital.enums.EstadoCuenta;
import com.banca.digital.banca_digital.enums.TipoOperacion;
import com.banca.digital.banca_digital.exceptions.ClienteNotFoundException;
import com.banca.digital.banca_digital.repository.ClienteRepository;
import com.banca.digital.banca_digital.repository.CuentaBancariaRepository;
import com.banca.digital.banca_digital.repository.OperacionCuentaRepository;
import com.banca.digital.banca_digital.services.BancoServices;
import com.banca.digital.banca_digital.services.CuentaBancariaServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BancaDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancaDigitalApplication.class, args);
	}

	//@Bean
	CommandLineRunner commandLineRunner(BancoServices bancoServices){
		return args -> {
			bancoServices.consultar();
		};
	}

	//@Bean
	CommandLineRunner start(CuentaBancariaServices cuentaBancariaServices){
		return  args -> {
			Stream.of("Edna", "Leiden", "Oliver", "Dupont").forEach(nombre -> {
				ClienteDTO cliente = new ClienteDTO();
				cliente.setNombre(nombre);
				//cliente.setEmail(nombre + "@gmail.com");
				cuentaBancariaServices.saveCliente(cliente);

			});
			cuentaBancariaServices.listClientes().forEach(cliente -> {
				try {
					cuentaBancariaServices.saveCuentaBancariaActual(Math.random() * 90000,9000, cliente.getId());
					cuentaBancariaServices.saveCuentaBancariaAhorro(120000,5.5, cliente.getId());

					List<CuentaBancariaDTO> cuentaBancarias = cuentaBancariaServices.listCuentaBancaria();

					for (CuentaBancariaDTO cuentaBancaria : cuentaBancarias){
						for (int i = 0; i<10; i ++){
							String cuentaId;

							if (cuentaBancaria instanceof CuentaBancariaDTO){
								cuentaId = ((CuentaAhorroDTO) cuentaBancaria).getId();
							}else {
								cuentaId = ((CuentaActualDTO) cuentaBancaria).getId();
							}
							cuentaBancariaServices.credit(cuentaId, 10000*Math.random()*120000,"credito");
							cuentaBancariaServices.debit(cuentaId, 1000*Math.random()*9000,"debito");
						}
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			});
		};
	}
}
