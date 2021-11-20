package com.bank.demo.repositories;

import com.bank.demo.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository // // Indica a JPA que la clase pertenece a la capa de persistencia, para que actúe como repositorio de métodos para la base de datos.
public interface CuentaRepositorio extends JpaRepository<Cuenta, Long> {

}
