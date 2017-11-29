<%-- 
    Document   : pedidos
    Created on : 27-11-2017, 9:42:54
    Author     : Matias
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis Pedidos</title>
        <jsp:include page="menu.jsp"></jsp:include>
        </head>
        <body class="body colorletra">
            <!--Cuerpo-->
            <div class="header" >
                <div class="panel-heading" >

                    <div class="panel-body" >
                        <table class="table table-condensed colorletra">
                            <tr>
                                <th>Numero Pedido: </th>
                                <th>Combo: </th>
                                <th>Cliente Rut:</th>
                                <th>Nombre Cliente: </th>
                                <th>Cantidad: </th>
                                <th>total: </th>
                            </tr>
                        <c:forEach items="${listaPedidos}" var="a" >

                            <tr>
                                <td>${a.getIddetalle()}</td>
                                <td>${a.getProducto().getDescripcion()}</td>
                                <td>${a.getPedido().getCliente().getRut()}</td>
                                <td>${a.getPedido().getCliente().getNombre()}</td>
                                <td>${a.getPedido().getCantidad()} </td>
                                <td>${a.getTotal()} </td>

                            </tr>
                        </c:forEach>

                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
