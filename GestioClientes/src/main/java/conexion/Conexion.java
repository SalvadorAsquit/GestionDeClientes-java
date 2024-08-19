/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Salvador
 */
public class Conexion {
    public static Connection getConexion(){
    Connection conexion = null;
    var baseDatos = "jdbc";
    var url = "jdbc:mysql://localhost:3306/" + baseDatos;
    var usuario = "root";
    var pass = "";
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conexion = DriverManager.getConnection(url,usuario,pass);
        } catch (Exception e) {
            System.out.println("Error al conectarnos ala BD: " + e.getMessage());
        }
    return conexion;
    }
    
    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        if(conexion != null){
            System.out.println("Conectado: " + conexion);
        }else{
            System.out.println("Fallo en la conexion: " + conexion);
        }
    }
   
}
