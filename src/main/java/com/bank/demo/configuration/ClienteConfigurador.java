package com.bank.demo.configuration;

import com.bank.demo.entities.Cliente;
import com.bank.demo.repositories.CuentaRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class ClienteConfigurador {

    @Bean
    CommandLineRunner commandLineRunner(CuentaRepositorio cuentaRepositorio){
        return args -> {
            Cliente cliente1 = new Cliente();
            cliente1.setNombre("Pepe");
            cliente1.setApellido("Vega");
            cliente1.setTelefono("678959597");
            cliente1.setDireccion("Calle numero 3, Barcelona");
            Cliente cliente2 = new Cliente();
            cliente2.setNombre("Maria");
            cliente2.setApellido("Garcia");
            cliente2.setTelefono("666666666");
            cliente2.setDireccion("Calle numero 7, Madrid");
            Cliente cliente3 = new Cliente();
            cliente3.setNombre("Vicente");
            cliente3.setApellido("Etxebarria");
            cliente3.setTelefono("1111111");
            cliente3.setDireccion("Calle numero 10, Valencia");
        };

    }
}
