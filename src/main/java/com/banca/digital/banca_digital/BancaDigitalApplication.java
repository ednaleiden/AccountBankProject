package com.banca.digital.banca_digital;

import com.banca.digital.banca_digital.entities.Cliente;
import com.banca.digital.banca_digital.entities.CuentaActual;
import com.banca.digital.banca_digital.entities.CuentaAhorro;
import com.banca.digital.banca_digital.entities.OperacionCuenta;
import com.banca.digital.banca_digital.enums.EstadoCuenta;
import com.banca.digital.banca_digital.enums.TipoOperacion;
import com.banca.digital.banca_digital.repository.ClienteRepository;
import com.banca.digital.banca_digital.repository.CuentaBancariaRepository;
import com.banca.digital.banca_digital.repository.OperacionCuentaRepository;
import com.banca.digital.banca_digital.services.BancoServices;
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

	@Bean
	CommandLineRunner commandLineRunner(BancoServices bancoServices){
		return args -> {
			bancoServices.consultar();
		};
	}

	//@Bean
	CommandLineRunner start(ClienteRepository clienteRepository, CuentaBancariaRepository cuentaBancariaRepository, OperacionCuentaRepository operacionCuentaRepository){
		return  args -> {
			Stream.of("Edna","Leiden","Oliver","Dupont").forEach(nombre ->{
				Cliente cliente = new Cliente();
				cliente.setNombre(nombre);
				cliente.setEmail(nombre+"@gmail.com");
				clienteRepository.save(cliente);
			});

			//asignamos cuentas bancarias

			clienteRepository.findAll().forEach(cliente -> {
				CuentaActual cuentaActual = new CuentaActual();
				cuentaActual.setId(UUID.randomUUID().toString());
				cuentaActual.setBalance(Math.random()*90000);
				cuentaActual.setFechaCreacion(new Date());
				cuentaActual.setEstadoCuenta(EstadoCuenta.CREADA);
				cuentaActual.setCliente(cliente);
				cuentaActual.setSobregiro(9000);
				cuentaBancariaRepository.save(cuentaActual);

				CuentaAhorro cuentaAhorro = new CuentaAhorro();
				cuentaAhorro.setId(UUID.randomUUID().toString());
				cuentaAhorro.setBalance(Math.random()*90000);
				cuentaAhorro.setFechaCreacion(new Date());
				cuentaAhorro.setEstadoCuenta(EstadoCuenta.CREADA);
				cuentaAhorro.setCliente(cliente);
				cuentaAhorro.setTasaInteres(5.5);
				cuentaBancariaRepository.save(cuentaAhorro);
			});

			//agregamos operaciones
			cuentaBancariaRepository.findAll().forEach(cuentaBancaria -> {
				for (int i = 0; i < 10;i++) {
					OperacionCuenta operacionCuenta = new OperacionCuenta();
					operacionCuenta.setFechaOperacion(new Date());
					operacionCuenta.setMonto(Math.random() * 1200);
					operacionCuenta.setTipoOperacion(Math.random() > 0.5 ? TipoOperacion.DEBITO : TipoOperacion.CREDITO);
					operacionCuenta.setCuentaBancaria(cuentaBancaria);
					operacionCuentaRepository.save(operacionCuenta);
				}
			});
		};
	}
}
