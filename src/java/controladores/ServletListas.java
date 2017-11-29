/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.*;

import entidades.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matias
 */
@WebServlet(name = "ServletListas", urlPatterns = {"/ServletListas"})
public class ServletListas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String operacion = req.getParameter("op");
        operacion = operacion != null ? operacion : "";
        ProductoDAO dao = new ProductoDAO();
        HttpSession se = req.getSession();
        List<Producto> listaProductos = dao.Listar();
        DetallePedidoDAO daodetalle = new DetallePedidoDAO();
        List<Detallepedido> listaPedidos = daodetalle.Listar();

        switch (operacion) {
            case "pedido":
                req.setAttribute("listaProductos", listaProductos);
                se.setAttribute("listaPedidos", listaPedidos);
                req.getRequestDispatcher("/agregarpedido.jsp").forward(req, resp);

                break;
            case "cerrar":

                se.invalidate();
                resp.sendRedirect("index.jsp");

                break;
            case "ListarPedidos":

                se.setAttribute("listaPedidos", listaPedidos);
                req.getRequestDispatcher("/pedidos.jsp").forward(req, resp);
                break;
        }
    }

}
