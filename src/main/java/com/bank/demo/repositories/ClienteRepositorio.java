package com.bank.demo.repositories;

import com.bank.demo.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//CrudRepository mainly provides CRUD functions.
// JpaRepository provides some JPA-related methods such as flushing the persistence context and deleting records in a batch.
// Por herencia, JpaRepository incluye todas las funcionalidades de CrudRepository

/**
 * Este repositorio extiende de JpaRepository y tiene como objetivo gestionar Clientes, y con Long para ID
 */
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    // podemos definirnos métodos extras a los que ya hay, como por ejemplo:
    @Query("SELECT * FROM Cliente WHERE email = ?")
    Cliente findClientByEmail(String email);
}
