package com.bank.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que crea una objeto de tipo ConexionBBDD para simplificar el acceso a base de datos SQL
 */

public class ConexionSingleton {

    // sólo una instancia es creada
    private static Connection conexion = null;
    private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String urlBaseDatos = "jdbc:mysql://localhost:3306/test";
    private String usuario = "usuario";
    private String password = "password";


    /**
     * Creamos un constructor privado, ya que sólo nos interesa una instancia para la conexion
     */
    private ConexionSingleton(){
        try{
            Class.forName(this.jdbcDriver);
            conexion = DriverManager.getConnection(this.urlBaseDatos, this.usuario, this.password);
            conexion.setAutoCommit(false); // seguiremos el modelo Transaction. O se hacen todas las operaciones o ninguna.
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    // Métodos

    /**
     * Obtenemos la conexión. Si es nula, se instancia.
     * @return Retorna un objeto de tipo conexion.
     */
    public static Connection getConnection(){

        if (conexion == null){
            new ConexionSingleton();
        }
        return conexion;
    } // Fin getConnection

    /**
     * Método que cierra la conexion
     */
    public static void closeConnection() {
        if (conexion != null)
        {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } // Fin closeConnection

    /*
        public void setConnectionParameters(String jdbcDriver, String urlBaseDatos, String usuario, String password) {
        this.jdbcDriver = jdbcDriver;
        this.urlBaseDatos = urlBaseDatos;
        this.usuario = usuario;
        this.password = password;
    }
     */

}