package com.bank.demo.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.sql.Date;

@Entity(name = "cliente")  //Indica a JPA que la clase es una entidad
// el name es por si la entidad no tiene el mismo nombre que la tabla. Ejemplo: no llamar a una entidad par_dis_aba
@Table   //Indica a JPA que tabla debe de mapear una entidad
@Getter @Setter @NoArgsConstructor // LOMBOK
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private String telefono;
    private Date fechaNacimiento;

}
