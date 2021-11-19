package com.bank.demo.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.sql.Date;

@Entity  //Indica a JPA que la clase es una entidad
@Table   //Indica a JPA que tabla debe de mapear una entidad
@Getter @Setter @NoArgsConstructor // LOMBOK
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuenta;
    private int idCliente;
    private String nombre;
    private double efectivo;
    private String divisa;
    private Date fechaAlta;

}