/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import clases.Cliente;
import java.util.List;

/**
 *
 * @author Salvador
 */
public interface IClienteDAO {
    List<Cliente> listarClientes();
    List<Cliente> buscarCliente(int id);
    String insertarCliente(Cliente cliente);
    String modificarCliente(Cliente cliente);
    String eliminarCliente(int id);
}
