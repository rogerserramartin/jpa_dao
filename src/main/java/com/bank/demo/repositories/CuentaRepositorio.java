package com.bank.demo.repositories;

import com.bank.demo.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Long> {
}
