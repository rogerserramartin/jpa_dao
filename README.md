# jpa_dao
### Pasos a seguir
<ol>
<li>Crear las entidades con sus atributos, mapeando las clases con las tablas.</li>
<li>Crear los repositorios, que extiendan JpaRepository</li>
<li>Crear los servicios, con inyección de dependencias de los repositorios</li>
<li>Crear el resto de funcionalidades del proyecto.</li>
<li>Tests con Junit.</li>
</ol>

##Scripts mysql
###Cliente
CREATE TABLE cliente (
id_cliente INT NOT NULL, 
nombre VARCHAR(20), 
apellido VARCHAR(20), 
direccion VARCHAR(50), 
email VARCHAR(50), 
telefono VARCHAR(20), 
fecha_nacimiento DATE, 
PRIMARY KEY(id_cliente)
);

###Cuenta
CREATE TABLE cuenta(id_cuenta INT NOT NULL, 
id_cliente INT NOT NULL, 
nombre VARCHAR(30), 
efectivo DOUBLE, 
divisa VARCHAR(20), 
fecha_alta DATE, 
PRIMARY KEY(id_cuenta), 
FOREIGN KEY(id_cliente) REFERENCES cliente (id_cliente) ON UPDATE CASCADE ON DELETE RESTRICT);