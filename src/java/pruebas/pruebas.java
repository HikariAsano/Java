/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import dao.ClienteDAO;
import dao.DetallePedidoDAO;
import entidades.Cliente;
import entidades.Detallepedido;
import java.util.List;

/**
 *
 * @author Matias
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        listardetalle();
        agregarCliente();

    }

    private static void listardetalle() {
        DetallePedidoDAO dao = new DetallePedidoDAO();
        List<Detallepedido> listaDetalle = dao.Listar();
        for (Detallepedido dp : listaDetalle) {

            System.out.println(dp.getProducto().getValor());
            System.out.println(dp.getTotal());
            System.out.println(dp.getProducto().getCantidad());
        }
    }

    private static void agregarCliente() {
        ClienteDAO dao = new ClienteDAO();
        Cliente cli = new Cliente("193814751", "Help me");

        boolean rsp = dao.Grabar(cli);
        System.out.println("mensaje: " + rsp);
    }

}
