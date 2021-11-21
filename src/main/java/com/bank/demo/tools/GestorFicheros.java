package com.bank.demo.tools;

import com.bank.demo.entities.Cliente;
import com.bank.demo.entities.Cuenta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que recibe un fichero e instancia objetos de tipo Cliente y Cuenta segun el registro.
 */
@Getter
@Setter

public class GestorFicheros {

    private String filepath;
    // para evitar inconsistencias, declaro estas variables como estaticas
    private  List<Cliente> clientes;
    private  List<Cuenta> cuentas;

    public GestorFicheros(String filepath){
        this.filepath = filepath;
        clientes = new ArrayList<>();
        cuentas = new ArrayList<>();

    }

    public void leerFichero(){
        try {
            String lineaActual;
            File fichero = new File(this.filepath);
            BufferedReader lector = new BufferedReader(new FileReader(fichero));
            while((lineaActual = lector.readLine())!= null){
                construirObjetos(lineaActual);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void construirObjetos(String lineaActual) {
        // A = Clientes
        // B = Cuentas
        char tipoFichero =  lineaActual.charAt(0);
        switch(tipoFichero){
            case 'A':
                instanciarCliente(lineaActual);
                break;
            case 'B':
                instanciarCuenta(lineaActual);
                break;
            default:
                break;
        }
    }

    private void instanciarCliente(String lineaActual) {

        Cliente cliente = new Cliente();
        // LEER FICHERO Y HACER LOS SETTERS;
        this.clientes.add(cliente);


    }

    private void instanciarCuenta(String lineaActual) {

        Cuenta cuenta = new Cuenta();
        // LEER FICHERO Y HACER LOS SETTERS;
        this.cuentas.add(cuenta);
    }



}
