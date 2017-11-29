/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.*;
import dao.*;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matias
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String btn = request.getParameter("btnAccion");

        if (btn.equals("Agregar")) {
            agregarPedido(request, response);
        }
        if (btn.equals("-")) {
            eliminardetalle(request, response);
        }
        if (btn.equals("Ingresar")) {
            inicio(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void agregarPedido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        //cliente
        String rut = request.getParameter("txtRut");
        String nombre = request.getParameter("txtNombre");
        Cliente cli = new Cliente(rut, nombre);
        ClienteDAO daocliente = new ClienteDAO();
        boolean rspc = daocliente.Grabar(cli);
        //generamos el pedido
        String formapago = request.getParameter("chkforma");
        boolean agranda = Boolean.parseBoolean(request.getParameter("chkagranda"));
        boolean llevar = Boolean.parseBoolean(request.getParameter("chkllevar"));
        int cant = Integer.parseInt(request.getParameter("txtCantidad"));
        Pedido pe = new Pedido(cli, formapago, agranda, llevar, cant);
        PedidoDAO daopedido = new PedidoDAO();

        boolean rspp = daopedido.Grabar(pe);

        //detalle pedido
        int idpro = Integer.parseInt(request.getParameter("cboProducto"));
        int valor = Integer.parseInt(request.getParameter("txtValor"));
        Producto pro = new Producto(idpro);
        int total = valor * cant;
        Detallepedido dp = new Detallepedido(pe, pro, total);
        DetallePedidoDAO dao = new DetallePedidoDAO();
        boolean rspdp = dao.Grabar(dp);
        if (sesion.getAttribute("totalapagar") != null) {
            int contador = (int) sesion.getAttribute("totalapagar");
            int suma = contador + total;
            sesion.setAttribute("totalapagar", suma);
        } else {
            request.setAttribute("totalapagar", total);
        }

        request.getRequestDispatcher("/index2.jsp").forward(request, response);
    }

    private void eliminardetalle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int iddp = Integer.parseInt(request.getParameter("txtiddp"));
        DetallePedidoDAO daodp = new DetallePedidoDAO();
        Detallepedido dp = new Detallepedido(iddp);
        boolean rspdp = daodp.Eliminar(dp);
        List<Detallepedido> listaPedidos = daodp.Listar();
        ProductoDAO dao = new ProductoDAO();
        List<Producto> listaProductos = dao.Listar();
        request.setAttribute("listaProductos", listaProductos);
        request.setAttribute("listaPedidos", listaPedidos);
        request.setAttribute("mensaje", "se elimino el producto");

        request.getRequestDispatcher("/agregarpedido.jsp").forward(request, response);

    }

    private void inicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("txtUser");
        String pass = request.getParameter("txtPass");
        HttpSession sesion = request.getSession();
        UsuarioDAO dao = new UsuarioDAO();

        for (Usuario us : dao.Listar()) {
            if (us.getContrasenia().equals(pass) && us.getUsuario().equals(user) && sesion.getAttribute("usuario") == null) {
                sesion.setAttribute("usuario", us.getUsuario());
                request.getRequestDispatcher("index2.jsp").forward(request, response);

            } else {
                request.setAttribute("mensaje", "El usuario o la contraseña es incorrecta");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        }
    }
}
