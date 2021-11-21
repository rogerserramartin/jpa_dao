package com.bank.demo;

import com.bank.demo.application.Application;
import com.bank.demo.entities.Cliente;
import com.bank.demo.repositories.ClienteRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;
import javax.annotation.Resource;

import java.util.List;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= Application.class)
@DataJpaTest
//@SpringBootTest salta excepcion de multiple declarations
class DemoApplicationTests {

	@Resource
	ClienteRepositorio clienteRepositorio;

	@Test
	void contextLoads() {
	}

	@Test
	void addClient(){
		Cliente cliente = new Cliente();
		cliente.setNombre("Abundio");
		cliente.setApellido("De la Vega");
		cliente.setDireccion("Calle de los pinos, 4, Badajoz");
		cliente.setEmail("abundio@abundio.es");
		cliente.setTelefono("660770880");
		clienteRepositorio.save(cliente);

	}

	@Test
	public void buscarClienteNombre(){
		List<Cliente> clientes = clienteRepositorio.findAll();
		assertThat(clientes).isNotEmpty().allMatch(cliente -> cliente.getNombre().equals("Marta"));

	}

}
