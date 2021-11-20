package com.bank.demo.services;

import com.bank.demo.entities.Cliente;
import com.bank.demo.repositories.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indica a JPA que esta clase pertenece a la capa de servicios. El servicio se encarga de la lógica del negocio.
public class ClienteService {

    private final ClienteRepositorio repositorioCliente;

    @Autowired // hace que internamente se haga el setter o la inyección de dependencias en el constructor
    // es decir, no hace un ClienteRepositorio = new, de forma explícita
    public ClienteService(ClienteRepositorio repositorioCliente){
        this.repositorioCliente = repositorioCliente;
    }

    public List<Cliente> obtenerClientes(){
        return this.repositorioCliente.findAll();
    }

    // usamos Optional porque el cliente podria estar o no, y sirve para gestionar bien los nulos
    public Optional<Cliente> getCliente(long id){
        return this.repositorioCliente.findById(id);
    }

    public void insertarCliente(Cliente cliente){
        this.repositorioCliente.save(cliente);
    }

    public void eliminarCliente(Long idCliente){
        this.repositorioCliente.deleteById(idCliente);
    }
    // no existe un metodo de modificar en el JPARepository, simplemente obtenemos el Cliente de la BBDD, y modificamos sus atrobutos
    public void modificarCliente(Cliente clienteDatosNuevos){
        String nombre = clienteDatosNuevos.getNombre();
        String apellido = clienteDatosNuevos.getApellido();
        long idCliente = clienteDatosNuevos.getIdCliente();
        this.repositorioCliente.modificarCliente(nombre, apellido, idCliente);

    // resto de metodos que queramos



    }




}
