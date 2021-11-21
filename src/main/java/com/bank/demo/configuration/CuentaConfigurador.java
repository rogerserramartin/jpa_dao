package com.bank.demo.configuration;

import com.bank.demo.entities.Cuenta;
import com.bank.demo.repositories.CuentaRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Esta clase llama a la interficie CommandLineRunner, para implementarla despues que la aplicación haya cargado.
 * Nos sirve para, por ejemplo, cargar datos y poder testear.
 */
@Configuration
public class CuentaConfigurador {

    @Bean
    CommandLineRunner commandLineRunner(CuentaRepositorio cuentaRepositorio){
        return args -> {
            Cuenta cuenta1 = new Cuenta();
            cuenta1.setNombre("Cuenta 1");
            cuenta1.setDivisa("Dolares");
            cuenta1.setEfectivo(20000);
            Cuenta cuenta2 = new Cuenta();
            cuenta2.setNombre("Cuenta 2");
            cuenta2.setDivisa("Euros");
            cuenta2.setEfectivo(300);
            Cuenta cuenta3 = new Cuenta();
            cuenta3.setNombre("Cuenta 3");
            cuenta3.setDivisa("Libras");
            cuenta3.setEfectivo(1000000);
            cuentaRepositorio.saveAll(List.of(cuenta1, cuenta2, cuenta3));
        };

    }
}
