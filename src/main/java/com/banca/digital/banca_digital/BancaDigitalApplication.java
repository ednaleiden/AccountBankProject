package com.banca.digital.banca_digital;

import com.banca.digital.banca_digital.entities.Cliente;
import com.banca.digital.banca_digital.entities.CuentaActual;
import com.banca.digital.banca_digital.entities.CuentaAhorro;
import com.banca.digital.banca_digital.entities.OperacionCuenta;
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

	@Bean
	CommandLineRunner start(CuentaBancariaServices cuentaBancariaServices){
		return  args -> {
			Stream.of("Edna", "Leiden", "Oliver", "Dupont").forEach(nombre -> {
				Cliente cliente = new Cliente();
				cliente.setNombre(nombre);
				cliente.setEmail(nombre + "@gmail.com");
				cuentaBancariaServices.saveCliente(cliente);

			});
			cuentaBancariaServices.listClientes().forEach(cliente -> {
				try {
					cuentaBancariaServices.saveCuentaBancariaActual(Math.random() * 90000,9000, cliente.getId())
				}catch (Exception e){
					e.printStackTrace();
				}
			});
		};
	}
}
