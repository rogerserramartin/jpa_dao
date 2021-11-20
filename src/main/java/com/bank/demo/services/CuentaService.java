package com.bank.demo.services;

import com.bank.demo.entities.Cuenta;
import com.bank.demo.repositories.CuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica a JPA que esta clase pertenece a la capa de servicios. El servicio se encarga de la lógica del negocio.
public class CuentaService {

    private final CuentaRepositorio repositorioCuenta;

    @Autowired
    public CuentaService(CuentaRepositorio repositorioCuenta){
        this.repositorioCuenta = repositorioCuenta;

    }

    public List<Cuenta> obtenerCuentas(){
        return  this.repositorioCuenta.findAll();
    }

    public Optional<Cuenta> obtenerCuenta(long id){
        return this.repositorioCuenta.findById(id);
    }

    public void eliminarCuenta(long id){
        this.repositorioCuenta.deleteById(id);

    }

    public void insertarCuenta(Cuenta cuenta){
        this.repositorioCuenta.save(cuenta);
    }
}
