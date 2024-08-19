/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package gestion.gestioclientes;

import java.util.Scanner;
import datos.ClienteDAO;
import clases.Cliente;

/**
 *
 * @author Salvador
 */
public class GestioClientes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteDAO dao = new ClienteDAO();
        var opcion = 0;
        String nombre;
        String apellido;
        int id;

        while (opcion != 5) {
            System.out.println("");
            System.out.println("*** Bienvenido al menu de gestion ***");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Mostrar los clientes");
            System.out.println("4. Modificar un cliente");
            System.out.println("5. Salir \n");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca los datos del cliente");
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Apellido: ");
                    apellido = sc.nextLine();
                    Cliente cliente = new Cliente(nombre, apellido);
                    System.out.println(dao.insertarCliente(cliente));

                    break;
                case 2:
                    mostrarCliente();
                    System.out.println("Introduzca el Id del cliente a eliminar");
                    id = Integer.parseInt(sc.nextLine());
                    System.out.println(dao.eliminarCliente(id));
                    
                    break;
                case 3:
                    mostrarCliente();
                    break;
                case 4:
                    mostrarCliente();
                    System.out.println("Introduzca los datos a modificar");
                    System.out.println("Id del usuario a modificar");
                    id = Integer.parseInt(sc.nextLine());;
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    apellido = sc.nextLine();
                    Cliente clienteModificado = new Cliente(nombre, apellido);
                    clienteModificado.setId(id);
                    dao.modificarCliente(clienteModificado);
               
                    
                    
                    break;
                default:
                    System.out.println("No es una opcion valida");
                    ;
            }

        }

    }

    public static void mostrarCliente() {
        ClienteDAO dao = new ClienteDAO();
        System.out.println("Estos son los datos de los cliente");
        var clientes = dao.listarClientes();
        clientes.forEach(System.out::println);
        System.out.println(" ");
    }
}
