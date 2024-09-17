package com.banca.digital.banca_digital.services;

import com.banca.digital.banca_digital.entities.CuentaActual;
import com.banca.digital.banca_digital.entities.CuentaAhorro;
import com.banca.digital.banca_digital.entities.CuentaBancaria;
import com.banca.digital.banca_digital.repository.CuentaBancariaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BancoServices {

    @Autowired
    private CuentaBancariaRepository cuentaBancariaRepository;

    public void  consultar(){
        CuentaBancaria cuentaBancaria = cuentaBancariaRepository.findById("14192f1d-6930-4d82-b505-b7981f56164d").orElse(null);

        if (cuentaBancaria != null) {
            System.out.println("****************************");
            System.out.println("ID :" +cuentaBancaria.getId());
            System.out.println("Balance :" +cuentaBancaria.getBalance());
            System.out.println("Estado Cuenta:" +cuentaBancaria.getEstadoCuenta());
            System.out.println("Fecha creacion:" +cuentaBancaria.getFechaCreacion());
            System.out.println("Nombre de cliente:" +cuentaBancaria.getCliente().getNombre());
            System.out.println("Nombre de Clase :" + cuentaBancaria.getClass().getSimpleName());

            if (cuentaBancaria instanceof CuentaActual){
                System.out.println("Sobregiro :" +((CuentaActual) cuentaBancaria).getSobregiro() );
            } else if (cuentaBancaria instanceof CuentaAhorro) {
                System.out.println("Tasa de interes :" + ((CuentaAhorro) cuentaBancaria).getTasaInteres());
            }

            cuentaBancaria.getOperacionCuentas().forEach(operacionCuenta-> {
                System.out.println("-----------------------------------");
                System.out.println("Tipo de operacion :" + operacionCuenta.getTipoOperacion());
                System.out.println("Fecha de operacion" + operacionCuenta.getFechaOperacion());
                System.out.println("Monto :" + operacionCuenta.getMonto());
            });
        }
    }
}
