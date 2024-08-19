/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import clases.Cliente;
import conexion.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salvador
 */
public class ClienteDAO implements IClienteDAO {

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        var sql = "SELECT * FROM cliente;";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Erro en el listad: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }

        return clientes;
    }

    @Override
    public List<Cliente> buscarCliente(int id) {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        var sql = "SELECT * FROM cliente WHERE id = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("No Existe el Cliente");
            }

            while (rs.next()) {
                var cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                clientes.add(cliente);
            }

        } catch (Exception e) {
            System.out.println("Error buscar al cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }

        return clientes;
    }

    @Override
    public String insertarCliente(Cliente cliente) {
        String response = "Error al Añadir";

        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        var sql = "INSERT INTO `cliente`(`Nombre`, `Apellido`) VALUES ( ?, ?) ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.execute();
            response = "Añadido con Exito";

        } catch (Exception e) {
            System.out.println("Error al añadir el cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return response;
    }

    @Override
    public String modificarCliente(Cliente cliente) {
        String response = "Error al Modificar";

        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        var sql = "UPDATE `cliente` SET `Nombre`= ?,`Apellido`= ? WHERE  id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getId());
            ps.execute();
            response = "Modificado con Exito";

        } catch (Exception e) {
            System.out.println("Error al añadir el cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return response;
    }

    @Override
    public String eliminarCliente(int id) {
        String response = "Error al eliminar";
        Connection con = Conexion.getConexion();
        PreparedStatement ps;
        var sql = "Delete from cliente WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            response = "Eliminado con Exito";

        } catch (Exception e) {
            System.out.println("Error al eliminar al cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion: " + ex.getMessage());
            }
        }
        return response;
    }

    public static void main(String[] args) {
        /*
        System.out.println("*** Listar Clientes ***");
        IClienteDAO clienteDao = new ClienteDAO();
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);
         */
 /*
        System.out.println("*** Buscar Clientes ***");
        IClienteDAO clienteDao = new ClienteDAO();
        var clientes = clienteDao.buscarCliente("Pepe");
        clientes.forEach(System.out::println);
         */
 /*
        System.out.println("*** Añadir Clientes ***");
        IClienteDAO clienteDao = new ClienteDAO();
        var cliente = new Cliente("Aida", "Asquit");
         var resultado = clienteDao.insertarCliente(cliente);
         System.out.println(resultado);
         */
 /*
        System.out.println("*** Modificar Clientes ***");
        IClienteDAO clienteDao = new ClienteDAO();
        var cliente = new Cliente("Rocio", "Ezoz");
        cliente.setId(4);
        var resultado = clienteDao.modificarCliente(cliente);
        System.out.println(resultado);
         */
 /*
        System.out.println("*** Modificar Clientes ***");
        IClienteDAO clienteDao = new ClienteDAO();
        var resultado = clienteDao.eliminarCliente(3);
        System.out.println(resultado);
         */
    }
}
