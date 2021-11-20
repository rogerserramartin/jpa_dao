package com.bank.demo.repositories;

import com.bank.demo.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// en una interfaz los metodos son publicos por defecto, pero es buena praxis declararlos igualmente

//CrudRepository mainly provides CRUD functions.
// JpaRepository provides some JPA-related methods such as flushing the persistence context and deleting records in a batch.
// Por herencia, JpaRepository incluye todas las funcionalidades de CrudRepository

/**
 * Este repositorio extiende de JpaRepository y tiene como objetivo gestionar Clientes, y con Long para ID
 */
@Repository  // Indica a JPA que la clase pertenece a la capa de persistencia, para que actúe como repositorio de métodos para la base de datos.
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    // podemos definirnos métodos extras a los que ya hay, como por ejemplo:
    @Query("SELECT * FROM Cliente WHERE email = ?")
    public Cliente findClientByEmail(String email);

    // hacer un update enn Jpa es bastante tedioso, asi que podemos definir nuestro propio metodo
    @Modifying // le dice a Jpa que la query es un update y que el prepared statement debe hacer un executeUpdate() no un executeQuery()
    @Query("UPDATE Cliente c set c.nombre = :nombre, c.apellido = :apellido WHERE c.id_cliente = :id") //Query sirve para definir una query customizada
    public void modificarCliente(@Param("nombre") String nombre,
                                 @Param("apellido") String apellido,
                                 @Param("id") long id);

    @Modifying
    @Query("delete Cliente c where c.nombre = :nombre")
    public String eliminarUsuarioPorNombre();
}
